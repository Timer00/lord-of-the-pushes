package com.lordofthepushes.services.impl;

import com.lordofthepushes.dao.CharacterDAO;
import com.lordofthepushes.exceptions.UnknownIdentifierException;
import com.lordofthepushes.dao.UserDAO;
import com.lordofthepushes.data.UserData;
import com.lordofthepushes.services.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.Optional;

@Service
public class DefaultUserService implements UserService {
    private static final Logger LOG = LogManager.getLogger(DefaultUserService.class);

    private UserDAO userDAO;
    private CharacterDAO characterDAO;

    @Override
    public void saveUser(UserData userData) {
        userDAO.save(userData);
    }

    @Override
    public void updateUser(UserData userData) {
        saveUser(userData);
    }

    @Override
    public void deleteUser(Long userId) {
        Assert.notNull(userId, "User Id must no be null!");
        UserData user = getUserById(userId);
        user.setActive(false);
        saveUser(user);
    }

    @Override
    public UserData getUserById(Long userId) {
        Assert.notNull(userId, "User Id must not be null!");
        Optional<UserData> user = userDAO.findById(userId);
        if (!user.isPresent()) {
            throw new UnknownIdentifierException("User " + userId + " not found!");
        }

        return user.get();
    }

    @Override
    public Iterable<UserData> getAllUsers() {
        return userDAO.findAll();
    }

    @Override
    public Iterable<UserData> getAllUsers(Pageable page) {
        return userDAO.findAll(page);
    }

    @Autowired
    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public UserDAO getUserDAO() {
        return userDAO;
    }

    @Autowired
    private void setCharacterDAO(CharacterDAO characterDAO) {
        this.characterDAO = characterDAO;
    }

    private CharacterDAO getCharacterDAO() {
        return characterDAO;
    }
}

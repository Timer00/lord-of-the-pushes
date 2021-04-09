package com.lordofthepushes.services.user.impl;

import com.lordofthepushes.dao.CharacterDAO;
import com.lordofthepushes.exceptions.UnknownIdentifierException;
import com.lordofthepushes.dao.UserDAO;
import com.lordofthepushes.data.UserData;
import com.lordofthepushes.services.user.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service("userService")
public class DefaultUserService implements UserService {
    private static final Logger LOG = LogManager.getLogger(DefaultUserService.class);

    private UserDAO userDAO;
    private CharacterDAO characterDAO;

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
    public UserData getUserById(Long userId) throws UnknownIdentifierException {
        Assert.notNull(userId, "User Id must not be null!");
        try {
            return userDAO.findById(userId).get();
        } catch (UnknownIdentifierException e){
            throw new UnknownIdentifierException("User " + userId + " not found!");
        }
    }

    @Override
    public Iterable<UserData> getAllUsers() {
//        Iterable<UserData> users = userDAO.findAll();
//        users.forEach(p -> p.setCharacters(characterDAO.findByUser(p)));
        return userDAO.findAll();
    }

    @Override
    public Iterable<UserData> getAllUsers(Pageable page) {
        return userDAO.findAll(page);
    }
}

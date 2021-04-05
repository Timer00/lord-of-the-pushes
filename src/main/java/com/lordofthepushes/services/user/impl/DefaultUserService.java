package com.lordofthepushes.services.user.impl;

import com.lordofthepushes.exceptions.UnknownIdentifierException;
import com.lordofthepushes.dao.user.UserDAO;
import com.lordofthepushes.data.UserData;
import com.lordofthepushes.services.user.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service("userService")
public class DefaultUserService implements UserService {
    private static final Logger LOG = LogManager.getLogger(DefaultUserService.class);

    private UserDAO userDAO;

    @Autowired
    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public UserDAO getUserDAO() {
        return userDAO;
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
    public void deleteUser(Integer userId) {
        UserData user = getUserById(userId);
        user.setActive(false);
        saveUser(user);
    }

    @Override
    public UserData getUserById(Integer userId) throws UnknownIdentifierException {
        if(userDAO.existsById(userId)) {
            return userDAO.findById(userId).get();
        } else {
            throw new UnknownIdentifierException("User " + userId + "not found!");
        }
    }

    @Override
    public Iterable<UserData> getAllUsers() {
        return userDAO.findAll();
    }

    @Override
    public Iterable<UserData> getAllUsers(Pageable page) {
        return userDAO.findAll(page);
    }
}
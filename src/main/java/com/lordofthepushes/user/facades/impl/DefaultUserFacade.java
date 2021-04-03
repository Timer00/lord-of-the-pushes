package com.lordofthepushes.user.facades.impl;

import com.lordofthepushes.user.data.UserData;
import com.lordofthepushes.user.facades.UserFacade;
import com.lordofthepushes.user.services.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Component
public class DefaultUserFacade implements UserFacade {

    private static final Logger LOG = LogManager.getLogger(DefaultUserFacade.class);

    UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public UserService getUserService() {
        return userService;
    }

    @Override
    public void saveUser(UserData userData) {
        userService.saveUser(userData);
    }

    @Override
    public void updateUser(UserData userData) {
        userService.updateUser(userData);
    }

    @Override
    public void deleteUser(Integer userId) {
        userService.deleteUser(userId);
    }

    @Override
    public UserData getUserById(Integer userId) {
        LOG.debug("Entering getUserById in DefaultUserFacade.class...");

        return userService.getUserById(userId);
    }

    @Override
    public Iterable<UserData> getAllUsers() {
        return userService.getAllUsers();
    }

    @Override
    public Iterable<UserData> getAllUsers(Pageable page) {
        return userService.getAllUsers(page);
    }
}

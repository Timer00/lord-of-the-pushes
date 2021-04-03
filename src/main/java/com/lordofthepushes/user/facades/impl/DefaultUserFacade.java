package com.lordofthepushes.user.facades.impl;

import com.lordofthepushes.user.data.UserData;
import com.lordofthepushes.user.facades.UserFacade;
import com.lordofthepushes.user.services.UserService;
import com.lordofthepushes.user.services.impl.DefaultUserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.util.List;

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
    public UserData getUserById(Integer userId) {
        LOG.debug("Entering getUserById in DefaultUserFacade.class...");
        LOG.debug("Value of id: " + userId);
        Assert.notNull(userId, "User id cannot be null");

        return userService.getUserById(userId);
    }

    @Override
    public UserData saveUser(UserData userData) {
        userService.save(userData);
        return  userData;
    }

    @Override
    public List<UserData> getUsers() {
        return null;
    }
}

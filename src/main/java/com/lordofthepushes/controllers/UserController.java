package com.lordofthepushes.controllers;

import com.lordofthepushes.data.UserData;
import com.lordofthepushes.facades.UserFacade;
import com.lordofthepushes.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class UserController {

    private UserFacade userFacade;

    @RequestMapping(path = {"/users"}, method = {RequestMethod.GET})
    public Iterable<UserData> getAllUsers() {
        return userFacade.getAllUsers();
    }

    @RequestMapping(path = "/users/{userId}")
    public UserData getClientById(@PathVariable(value = "userId") Long userId) {
        return userFacade.getUserById(userId);
    }

    @RequestMapping(path = {"/users/page/{pageNumber}/{qtdPage}"}, method = {RequestMethod.GET})
    Iterable<UserData> getUsersByPage(@PathVariable(value = "pageNumber") Integer pageNumber, @PathVariable("qtdPage") Integer qtdPage) {
        Pageable page = Util.verifyPageable(pageNumber, qtdPage);
        return userFacade.getAllUsers(page);
    }

    @RequestMapping(value = "/users/save", method = {RequestMethod.POST})
    public UserData saveUser(@Valid UserData userData) {
        userFacade.saveUser(userData);
        return userData;
    }

    @RequestMapping(value = "/users/update", method = {RequestMethod.POST, RequestMethod.PATCH})
    public UserData updateUser(@Valid UserData userData) {
        userFacade.updateUser(userData);
        return userData;
    }

    @RequestMapping(value = {"/users/users/delete"}, method = {RequestMethod.POST, RequestMethod.DELETE})
    public String deleteUser(@RequestParam(value = "userID") Long userId) {
        userFacade.deleteUser(userId);
    return "{200}";
    }

    @Autowired
    public void setClientFacade(UserFacade userFacade) {
        this.userFacade = userFacade;
    }
}

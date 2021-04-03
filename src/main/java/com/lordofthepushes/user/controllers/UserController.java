package com.lordofthepushes.user.controllers;

import com.lordofthepushes.user.data.UserData;
import com.lordofthepushes.user.facades.UserFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Null;

@RestController
@RequestMapping(path = {"/api/users"})
public class UserController {

    private UserFacade userFacade;

    @Autowired
    public void setClientFacade(UserFacade userFacade) {
        this.userFacade = userFacade;
    }

    public UserFacade getClientFacade() {
        return userFacade;
    }

    @RequestMapping(method = {RequestMethod.GET})
    public Iterable<UserData> getAllUsers() {
        return userFacade.getAllUsers();
    }

    @RequestMapping(path = "/{userId}")
    public UserData getClientById(@PathVariable(value = "userId") Integer userId) {
        return userFacade.getUserById(userId);
    }

    @RequestMapping(path = {"/page/{pageNumber}/{qtdPage}"}, method = {RequestMethod.GET})
    Iterable<UserData> getUsersByPage(@PathVariable(value = "pageNumber") Integer pageNumber, @PathVariable("qtdPage") Integer qtdPage) {
        if (qtdPage > 5 ) {
            qtdPage = 5;
        }
        if (qtdPage < 1) {
            qtdPage = 1;
        }
        pageNumber++;
        Pageable page = PageRequest.of(pageNumber, qtdPage);
        return userFacade.getAllUsers(page);
    }

    @RequestMapping(value = "/save", method = {RequestMethod.POST})
    public UserData saveUser(@RequestBody @Valid UserData userData) {
        userFacade.saveUser(userData);
        return userData;
    }

    @RequestMapping(value = "/update", method = {RequestMethod.POST, RequestMethod.PATCH})
    public UserData updateUser(@RequestBody @Valid UserData userData) {
        userFacade.updateUser(userData);
        return userData;
    }

    @RequestMapping(value = {"/delete"}, method = {RequestMethod.POST, RequestMethod.DELETE})
    public String deleteUser(@RequestParam(value = "userID") Integer userId) {
        userFacade.deleteUser(userId);
    return "{200}";
    }
}

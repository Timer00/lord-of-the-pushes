package com.lordofthepushes.user.controllers;

import com.lordofthepushes.user.data.UserData;
import com.lordofthepushes.user.facades.UserFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

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

    @GetMapping(path = "/{userId}")
    public UserData getClientById(@PathVariable(value = "userId") String userId) throws UnsupportedEncodingException {
        final String decodedUserId = URLDecoder.decode(userId, "UTF-8");
        return userFacade.getUserById(Integer.parseInt(decodedUserId));
    }

    @RequestMapping(method = {RequestMethod.POST},  value = "/save")
    public UserData saveUser(@RequestBody @Valid UserData userData) {
        return userFacade.saveUser(userData);
    }
}

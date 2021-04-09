package com.lordofthepushes.controllers;

import com.lordofthepushes.dao.CharacterDAO;
import com.lordofthepushes.dao.UserDAO;
import com.lordofthepushes.data.CharacterData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CharacterController {

    @Autowired
    private CharacterDAO characterDAO;

    @Autowired
    private UserDAO userDAO;

    @RequestMapping(path = {"/characters"})
    private Iterable<CharacterData> getCharactersByUser(@RequestParam(value = "user") Long userId) {
        return characterDAO.findByUser(userDAO.findById(userId).get());
    }
}

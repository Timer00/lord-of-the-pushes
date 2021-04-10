package com.lordofthepushes.controllers;

import com.lordofthepushes.data.CharacterData;
import com.lordofthepushes.facades.CharacterFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CharacterController {

    private CharacterFacade characterFacade;

    @RequestMapping(path = {"/characters"}, params = {"user"})
    private Iterable<CharacterData> getCharactersByUser(@RequestParam(value = "user") Long userId) {
        return characterFacade.getAllCharactersByUser(userId);
    }

    @RequestMapping(path = {"/characters"}, params = {"user", "characterName"})
    private CharacterData getCharactersByUser(@RequestParam(value = "user") Long userId, @RequestParam("characterName") String name) {
        return characterFacade.getCharacterByName(userId, name);
    }

    @Autowired
    public void setCharacterFacade(CharacterFacade characterFacade) {
        this.characterFacade = characterFacade;
    }

    public CharacterFacade getCharacterFacade() {
        return characterFacade;
    }
}

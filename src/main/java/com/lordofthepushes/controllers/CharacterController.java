package com.lordofthepushes.controllers;

import com.lordofthepushes.data.CharacterData;
import com.lordofthepushes.facades.CharacterFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CharacterController {

    private CharacterFacade characterFacade;

    @RequestMapping(path = {"/characters"})
    private List<CharacterData> getCharactersByUser() {
        return characterFacade.getAllCharacters();
    }

    @RequestMapping(path = {"/characters"}, params = {"characterId"})
    private CharacterData getCharactersById(@RequestParam(value = "characterId") Long characterId) {
        return characterFacade.getCharacter(characterId);
    }

    @RequestMapping(path = {"/characters"}, params = {"user", "characterName"})
    private CharacterData getCharactersByUser(@RequestParam(value = "user") Long userId, @RequestParam("characterName") String name) {
        return characterFacade.getCharacter(userId, name);
    }

    @RequestMapping(path = {"/characters"}, params = {"user"})
    private List<CharacterData> getCharactersByUser(@RequestParam(value = "user") Long userId) {
        return characterFacade.getAllCharactersByUser(userId);
    }

    @Autowired
    public void setCharacterFacade(CharacterFacade characterFacade) {
        this.characterFacade = characterFacade;
    }

}

package com.lordofthepushes.controllers;

import com.lordofthepushes.data.CharacterData;
import com.lordofthepushes.facades.CharacterFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CharacterController {

    private CharacterFacade characterFacade;

    @RequestMapping(path = {"/characters"}, method = {RequestMethod.GET, RequestMethod.POST})
    public List<CharacterData> getCharactersByUser() {
        return characterFacade.getAllCharacters();
    }

    @RequestMapping(path = {"/characters"}, method = {RequestMethod.GET, RequestMethod.POST}, params = {"characterId"})
    public CharacterData getCharactersById(@RequestParam(value = "characterId") Long characterId) {
        return characterFacade.getCharacter(characterId);
    }

    @RequestMapping(path = {"/characters"}, method = {RequestMethod.GET, RequestMethod.POST}, params = {"user", "characterName"})
    public CharacterData getCharactersByUser(@RequestParam(value = "user") Long userId, @RequestParam("characterName") String name) {
        return characterFacade.getCharacter(userId, name);
    }

    @RequestMapping(path = {"/characters"}, method = {RequestMethod.GET, RequestMethod.POST}, params = {"user"})
    public List<CharacterData> getCharactersByUser(@RequestParam(value = "user") Long userId) {
        return characterFacade.getAllCharactersByUser(userId);
    }

    @RequestMapping(path = {"/characters/update"}, method = {RequestMethod.PATCH, RequestMethod.POST}, params = {"character"})
    public CharacterData updateCharacter(@RequestParam("character") CharacterData character) {
        return characterFacade.updateCharacter(character);
    }

    @RequestMapping(path = {"/character/delete"}, method = {RequestMethod.DELETE, RequestMethod.POST}, params = {"character"})
    public CharacterData deleteCharacter(@RequestParam("character") CharacterData character) {
        return characterFacade.deleteCharacter(character.getCharacterId());
    }


    @Autowired
    public void setCharacterFacade(CharacterFacade characterFacade) {
        this.characterFacade = characterFacade;
    }

}

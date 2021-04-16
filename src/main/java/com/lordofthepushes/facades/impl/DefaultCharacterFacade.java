package com.lordofthepushes.facades.impl;

import com.lordofthepushes.data.AdventureTableData;
import com.lordofthepushes.data.CharacterData;
import com.lordofthepushes.data.UserData;
import com.lordofthepushes.facades.CharacterFacade;
import com.lordofthepushes.services.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("characterFacade")
public class DefaultCharacterFacade implements CharacterFacade {
    private CharacterService characterService;

    @Override
    public CharacterData saveCharacter(CharacterData characterData) {
        return characterService.saveCharacter(characterData);
    }

    @Override
    public CharacterData deleteCharacter(Long characterId) {
        return characterService.deleteCharacter(characterId);
    }

    @Override
    public CharacterData updateCharacter(CharacterData characterData) {
        return characterService.updateCharacter(characterData);
    }

    @Override
    public CharacterData getCharacter(Long characterId) {
        return characterService.getCharacter(characterId);
    }

    @Override
    public CharacterData getCharacter(Long userId, String characterName) {
        return characterService.getCharacter(userId, characterName);
    }

    @Override
    public List<CharacterData> getAllCharactersByUser(Long userId) {
        return characterService.getAllCharactersByUser(userId);
    }

    @Override
    public List<CharacterData> getAllCharacters() {
        return characterService.getAllCharacters();
    }

    @Override
    public List<CharacterData> getAllCharactersByUser(UserData user) {
        return characterService.getAllCharactersByUser(user);
    }

    @Override
    public List<CharacterData> getAllCharactersByUser(Long userId, Pageable page) {
        return characterService.getAllCharactersByUser(userId, page);
    }

    @Override
    public List<CharacterData> getAllCharacterByTable(AdventureTableData adventureTable) {
        return characterService.getAllCharacterByTable(adventureTable);
    }

    @Override
    public List<CharacterData> getAllCharacterByTable(AdventureTableData adventureTable, Pageable page) {
        return characterService.getAllCharacterByTable(adventureTable, page);
    }

    @Override
    public List<CharacterData> getAllCharacterByTable(Long tableId) {
        return characterService.getAllCharacterByTable(tableId);
    }

    @Override
    public List<CharacterData> getAllCharacterByTable(Long tableId, Pageable page) {
        return characterService.getAllCharacterByTable(tableId, page);
    }

    @Autowired
    public void setCharacterService(CharacterService characterService) {
        this.characterService = characterService;
    }
}

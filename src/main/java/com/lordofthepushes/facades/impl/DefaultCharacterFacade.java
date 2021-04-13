package com.lordofthepushes.facades.impl;

import com.lordofthepushes.data.CharacterData;
import com.lordofthepushes.facades.CharacterFacade;
import com.lordofthepushes.services.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DefaultCharacterFacade implements CharacterFacade {
    private CharacterService characterService;

    @Override
    public CharacterData saveCharacter(CharacterData characterData) {
        return null;
    }

    @Override
    public CharacterData updateCharacter(CharacterData characterData) {
        return null;
    }

    @Override
    public void deleteCharacter(Long characterId) {

    }

    @Override
    public CharacterData getCharacterByName(Long userId, String characterName) {
        return null;
    }

    @Override
    public List<CharacterData> getAllCharactersByUser(Long userId) {
        return characterService.getAllCharactersByUser(userId);
    }

    @Override
    public List<CharacterData> getAllCharactersByUser(Long userId, Pageable page) {
        return null;
    }

    @Override
    public List<CharacterData> getAllCharacterByTable(Long tableId) {
        return null;
    }

    @Override
    public List<CharacterData> getAllCharacterByTable(Long tableId, Pageable page) {
        return null;
    }

    @Autowired
    public void setCharacterService(CharacterService characterService) {
        this.characterService = characterService;
    }

    public CharacterService getCharacterService() {
        return characterService;
    }
}

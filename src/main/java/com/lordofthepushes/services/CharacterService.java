package com.lordofthepushes.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.lordofthepushes.data.AdventureTableData;
import com.lordofthepushes.data.CharacterData;
import com.lordofthepushes.data.UserData;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CharacterService {
    CharacterData saveCharacter(CharacterData characterData);
    CharacterData deleteCharacter(Long characterId);
    CharacterData updateCharacter(CharacterData characterData);
    CharacterData getCharacter(Long characterId);
    CharacterData getCharacter(Long userId, String characterName);
    List<CharacterData> getAllCharactersByUser(Long userId);
    List<CharacterData> getAllCharacters();
    List<CharacterData> getAllCharactersByUser(UserData user);
    List<CharacterData> getAllCharactersByUser(Long userId, Pageable page);
    List<CharacterData> getAllCharacterByTable(AdventureTableData adventureTable);
    List<CharacterData> getAllCharacterByTable(AdventureTableData adventureTable, Pageable page);
    List<CharacterData> getAllCharacterByTable(Long tableId);
    List<CharacterData> getAllCharacterByTable(Long tableId, Pageable page);
}
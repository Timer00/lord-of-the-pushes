package com.lordofthepushes.services;

import com.lordofthepushes.data.CharacterData;
import org.springframework.data.domain.Pageable;

public interface CharacterService {
    CharacterData saveCharacter(CharacterData characterData);
    CharacterData updateCharacter(CharacterData characterData);
    void deleteCharacter(Long characterId);
    CharacterData getCharactersByName(Long userId, String characterName);
    Iterable<CharacterData> getAllCharactersByUser(Long userId);
    Iterable<CharacterData> getAllCharactersByUser(Long userId, Pageable page);
    Iterable<CharacterData> getAllCharacterByTable(Long tableId);
    Iterable<CharacterData> getAllCharacterByTable(Long tableId, Pageable page);
}

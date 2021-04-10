package com.lordofthepushes.facades;

import com.lordofthepushes.data.CharacterData;
import org.springframework.data.domain.Pageable;

public interface CharacterFacade {
    CharacterData saveCharacter(CharacterData characterData);
    CharacterData updateCharacter(CharacterData characterData);
    void deleteCharacter(Long characterId);
    CharacterData getCharacterByName(Long userId, String characterName);
    Iterable<CharacterData> getAllCharactersByUser(Long userId);
    Iterable<CharacterData> getAllCharactersByUser(Long userId, Pageable page);
    Iterable<CharacterData> getAllCharacterByTable(Long tableId);
    Iterable<CharacterData> getAllCharacterByTable(Long tableId, Pageable page);
}

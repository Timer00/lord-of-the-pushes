package com.lordofthepushes.facades;

import com.lordofthepushes.data.CharacterData;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CharacterFacade {
    CharacterData saveCharacter(CharacterData characterData);
    CharacterData updateCharacter(CharacterData characterData);
    void deleteCharacter(Long characterId);
    CharacterData getCharacterByName(Long userId, String characterName);
    List<CharacterData> getAllCharactersByUser(Long userId);
    List<CharacterData> getAllCharactersByUser(Long userId, Pageable page);
    List<CharacterData> getAllCharacterByTable(Long tableId);
    List<CharacterData> getAllCharacterByTable(Long tableId, Pageable page);
}

package com.lordofthepushes.services.impl;

import com.lordofthepushes.dao.CharacterDAO;
import com.lordofthepushes.data.AdventureTableData;
import com.lordofthepushes.data.CharacterData;
import com.lordofthepushes.data.UserData;
import com.lordofthepushes.exceptions.UnknownIdentifierException;
import com.lordofthepushes.services.CharacterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultCharacterService implements CharacterService {

    private final Logger LOG = LoggerFactory.getLogger(DefaultCharacterService.class);

    private CharacterDAO characterDAO;

    @Override
    public CharacterData saveCharacter(CharacterData characterData) throws IllegalArgumentException {
        if (characterData.getFullName().equals("") || characterData.getFullName() == null) {
            characterData.setFullName(characterData.getFirstName().replaceAll(" ", "")
                    + " " + characterData.getLastName().replaceAll(" ", ""));
        }
        return characterDAO.save(characterData);
    }

    @Override
    public CharacterData updateCharacter(CharacterData characterData) {
        LOG.debug("Updating character with id: " + characterData.getCharacterId());

        if (getCharacter(characterData.getCharacterId()) == null){
            LOG.debug("No character found with ID: " + characterData.getCharacterId());

            throw new UnknownIdentifierException("Failed to get character with id: " + characterData.getCharacterId());
        }
        return characterDAO.update(characterData);
    }

    @Override
    public CharacterData deleteCharacter(Long characterId) {
        LOG.debug("Deleting character with id: " + characterId);

        CharacterData deleted = characterDAO.findByCharacterId(characterId);

        if (deleted == null ){
            LOG.debug("No character found with id: " + characterId);
            throw new UnknownIdentifierException("No character fund with id: " + characterId);
        }

        characterDAO.deleteById(characterId);

        return deleted;
    }

    @Override
    public List<CharacterData> getAllCharacters() {
        return characterDAO.getAll();
    }

    @Override
    public CharacterData getCharacter(Long characterId) {
        CharacterData result = characterDAO.findByCharacterId(characterId);

        if (result == null){
            LOG.debug("No character found with ID: " + characterId);
            throw new UnknownIdentifierException("Failed to get character with id: " + characterId);
        }

        return result;
    }

    @Override
    public CharacterData getCharacter(Long userId, String characterName) {
        return characterDAO.findByUserUserIdAndFirstName(userId, characterName);
    }

    @Override
    public List<CharacterData> getAllCharactersByUser(UserData user) {
        if (user == null) {
            LOG.error("User must not be null. User inserted: null");
            throw new IllegalArgumentException("The user id must not be null nor 0");
        }
        return characterDAO.findByUser(user);
    }

    @Override
    public List<CharacterData> getAllCharactersByUser(Long userId) {
        if (userId == null || userId == 0) {
            LOG.error("User id must not be null nor 0. Value inserted: " + userId);
            throw new IllegalArgumentException("The user id must not be null nor 0");
        }
        return characterDAO.findByUserUserId(userId);
    }

    @Override
    public List<CharacterData> getAllCharactersByUser(Long userId, Pageable page) {
        return characterDAO.findByUserUserId(userId, page);
    }

    @Override
    public List<CharacterData> getAllCharacterByTable(AdventureTableData adventureTable) {
        return characterDAO.findByTable(adventureTable);
    }

    @Override
    public List<CharacterData> getAllCharacterByTable(AdventureTableData adventureTable, Pageable page) {
        return characterDAO.findByTable(adventureTable, page);
    }

    @Override
    public List<CharacterData> getAllCharacterByTable(Long tableId) {
        return characterDAO.findByTableAdventureTableId(tableId);
    }
    @Override
    public List<CharacterData> getAllCharacterByTable(Long tableId, Pageable page) {
        return characterDAO.findByTableAdventureTableId(tableId, page);
    }

    @Autowired
    public void setCharacterDAO(CharacterDAO characterDAO) {
        this.characterDAO = characterDAO;
    }

    public CharacterDAO getCharacterDAO() {
        return characterDAO;
    }
}

package com.lordofthepushes.services.impl;

import com.lordofthepushes.dao.CharacterDAO;
import com.lordofthepushes.dao.UserDAO;
import com.lordofthepushes.data.CharacterData;
import com.lordofthepushes.exceptions.UnknownIdentifierException;
import com.lordofthepushes.services.CharacterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service
public class DefaultCharacterService implements CharacterService {

    Logger LOG = LoggerFactory.getLogger(DefaultCharacterService.class);

    private UserDAO userDAO;
    private CharacterDAO characterDAO;

    @Override
    public CharacterData saveCharacter(CharacterData characterData) {
        return characterDAO.save(characterData);
    }

    @Override
    public CharacterData updateCharacter(CharacterData characterData) {
        return saveCharacter(characterData);
    }

    @Override
    public void deleteCharacter(Long characterId) {

    }

    @Override
    public CharacterData getCharactersByName(Long userId, String characterName) {
        return characterDAO.findByUserUserIdAndFirstName(userId, characterName);
    }

    @Override
    public Iterable<CharacterData> getAllCharactersByUser(Long userId) {
        Assert.notNull(userId, "The user id must not be null");
        return characterDAO.findByUserUserId(userId);
    }

    @Override
    public Iterable<CharacterData> getAllCharactersByUser(Long userId, Pageable page) {
        return characterDAO.findByUserUserId(userId, page);
    }

    @Override
    public Iterable<CharacterData> getAllCharacterByTable(Long tableId) {
        return null;
    }

    @Override
    public Iterable<CharacterData> getAllCharacterByTable(Long tableId, Pageable page) {
        return null;
    }

    @Autowired
    public void setCharacterDAO(CharacterDAO characterDAO) {
        this.characterDAO = characterDAO;
    }

    public CharacterDAO getCharacterDAO() {
        return characterDAO;
    }

    @Autowired
    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public UserDAO getUserDAO() {
        return userDAO;
    }
}

package com.lordofthepushes.services;

import com.lordofthepushes.dao.CharacterDAO;
import com.lordofthepushes.data.AdventureTableData;
import com.lordofthepushes.data.CharacterData;
import com.lordofthepushes.data.UserData;
import com.lordofthepushes.services.impl.DefaultCharacterService;
import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import static org.mockito.Mockito.*;

public class DefaultCharacterUnitTest {

    private CharacterDAO characterDAO;
    private CharacterData characterModel;
    private DefaultCharacterService characterService;

    private UserData userModel;
    private AdventureTableData adventureTableModel;

    private static final Long USER_ID = 1L;
    private static final Long ADVENTURE_TABLE_ID = 1L;

    private static final Long CHARACTER_ID = 1L;
    private static final Boolean CHARACTER_ENABLED = true;
    private static final String CHARACTER_FIRST_NAME = "Parseval";
    private static final String CHARACTER_LAST_NAME = "Coldwind";
    private static final String CHARACTER_FULL_NAME = CHARACTER_FIRST_NAME + " " + CHARACTER_LAST_NAME;
    private static final Date CHARACTER_CREATED_AT = new Date();

    @BeforeEach
    public void setUp() {
        characterDAO = mock(CharacterDAO.class);

        characterService = new DefaultCharacterService();
        characterService.setCharacterDAO(characterDAO);

        characterModel = new CharacterData();
        characterModel.setCharacterId(CHARACTER_ID);
        characterModel.setEnabled(CHARACTER_ENABLED);
        characterModel.setFirstName(CHARACTER_FIRST_NAME);
        characterModel.setLastName(CHARACTER_LAST_NAME);
        characterModel.setFullName(CHARACTER_FULL_NAME);
        characterModel.setCreatedAt(CHARACTER_CREATED_AT);

        userModel = new UserData();
        adventureTableModel = new AdventureTableData();
        userModel.setUserId(USER_ID);
        adventureTableModel.setAdventureTableId(ADVENTURE_TABLE_ID);

        characterModel.setUser(userModel);
        characterModel.setTable(adventureTableModel);
    }

    @Test
    public void saveCharacterTest() {
        when(characterDAO.save(Mockito.any(CharacterData.class))).thenReturn(characterModel);

        final CharacterData result = characterService.saveCharacter(characterModel);

        verify(characterDAO, times(1)).save(Mockito.any(CharacterData.class));
        Assertions.assertEquals(characterModel, result);
    }

    @Test
    public void deleteCharacterTest() {
        when(characterDAO.findByCharacterId(CHARACTER_ID)).thenReturn(characterModel);
        characterService.deleteCharacter(CHARACTER_ID);
        verify(characterDAO, times(1)).deleteById(CHARACTER_ID);
    }

    @Test
    public void updateCharacterTest() {
        CharacterData updatedCharacter = characterModel;
        updatedCharacter.setFirstName("NewParseval");

        when(characterDAO.findByCharacterId(CHARACTER_ID)).thenReturn(updatedCharacter);
        when(characterDAO.update(Mockito.any(CharacterData.class))).thenReturn(updatedCharacter);

        CharacterData result = characterService.updateCharacter(updatedCharacter);

        verify(characterDAO, times(1)).update(updatedCharacter);
        Assertions.assertEquals(updatedCharacter, result);
    }

    @Test
    public void getAllCharactersTest() {
        final List<CharacterData> characterModels = Collections.singletonList(characterModel);
        when(characterDAO.getAll()).thenReturn(characterModels);
        final List<CharacterData> result = characterService.getAllCharacters();
        Assertions.assertEquals(1, result.size());
        Assertions.assertEquals(characterModels, result);
        Assertions.assertEquals(characterModel, result.get(0));
    }

    @Test
    public void getCharacterByIdTest() {
        when(characterDAO.findByCharacterId(CHARACTER_ID)).thenReturn(characterModel);
        when(characterDAO.findByUserUserIdAndFirstName(USER_ID, CHARACTER_FIRST_NAME)).thenReturn(characterModel);

        final CharacterData resultById = characterService.getCharacter(CHARACTER_ID);
        final CharacterData resultByName = characterService.getCharacter(USER_ID, CHARACTER_FIRST_NAME);

        Assertions.assertEquals(characterModel, resultById);
        Assertions.assertEquals(characterModel, resultByName);
    }

    @Test
    public void getAllCharactersByUser() {
        final List<CharacterData> characterModels = Collections.singletonList(characterModel);

        when(characterDAO.findByUserUserId(USER_ID)).thenReturn(characterModels);
        when(characterDAO.findByUser(userModel)).thenReturn(characterModels);

        final List<CharacterData> resultByUserId = characterService.getAllCharactersByUser(USER_ID);
        final List<CharacterData> resultByUser = characterService.getAllCharactersByUser(userModel);

        Assertions.assertEquals(1, resultByUserId.size());
        Assertions.assertEquals(characterModels, resultByUserId);
        Assertions.assertEquals(characterModel, resultByUserId.get(0));

        Assertions.assertEquals(1, resultByUser.size());
        Assertions.assertEquals(characterModels, resultByUser);
        Assertions.assertEquals(characterModel, resultByUser.get(0));
    }

    @Test
    public void getAllCharacterByTable() {
        final List<CharacterData> characterModels = Collections.singletonList(characterModel);

        when(characterDAO.findByTable(Mockito.any(AdventureTableData.class))).thenReturn(characterModels);
        when(characterDAO.findByTableAdventureTableId(ADVENTURE_TABLE_ID)).thenReturn(characterModels);

        final List<CharacterData> resultByTable = characterService.getAllCharacterByTable(adventureTableModel);
        final List<CharacterData> resultByTableId = characterService.getAllCharacterByTable(ADVENTURE_TABLE_ID);

        Assertions.assertEquals(1, resultByTable.size());
        Assertions.assertEquals(characterModels, resultByTable);
        Assertions.assertEquals(characterModel, resultByTable.get(0));

        Assertions.assertEquals(1, resultByTableId.size());
        Assertions.assertEquals(characterModels, resultByTableId);
        Assertions.assertEquals(characterModel, resultByTableId.get(0));
    }

}

package com.lordofthepushes.services;

import com.lordofthepushes.dao.CharacterDAO;
import com.lordofthepushes.data.AdventureTableData;
import com.lordofthepushes.data.CharacterData;
import com.lordofthepushes.data.UserData;
import com.lordofthepushes.exceptions.UnknownIdentifierException;
import com.lordofthepushes.services.impl.DefaultCharacterService;
import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import static com.lordofthepushes.util.Util.verifyPageable;
import static org.mockito.Mockito.*;

public class DefaultCharacterUnitTest {

    private CharacterDAO characterDAO;
    private CharacterData characterModel;
    private DefaultCharacterService characterService;

    private UserData userModel;
    private AdventureTableData adventureTableModel;

    private static final Long USER_ID = 1L;
    private static final Long ADVENTURE_TABLE_ID = 1L;

    private static final Integer PAGE_NUMBER = 1;
    private static final Integer QTD_PAGE = 1;

    private final Pageable PAGE = verifyPageable(PAGE_NUMBER, QTD_PAGE);

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

        final CharacterData resultComplete = characterService.saveCharacter(characterModel);

        verify(characterDAO, times(1)).save(Mockito.any(CharacterData.class));
        Assertions.assertEquals(characterModel, resultComplete);
    }

    @Test
    public void saveCharacterNoFullNameTest() {
        CharacterData characterNoMiddleName = characterModel;
        characterNoMiddleName.setFullName(" ");

        when(characterDAO.save(characterNoMiddleName)).thenReturn(characterNoMiddleName);

        final CharacterData resultNoMiddleName = characterService.saveCharacter(characterModel);

        verify(characterDAO, times(1)).save(characterNoMiddleName);
        Assertions.assertEquals(characterNoMiddleName, resultNoMiddleName);
    }

    @Test
    public void deleteCharacterTest() {
        CharacterData deleted = characterModel;
        deleted.setEnabled(false);

        when(characterDAO.findByCharacterId(CHARACTER_ID)).thenReturn(characterModel);
        when(characterDAO.save(deleted)).thenReturn(deleted);

        CharacterData result = characterService.deleteCharacter(CHARACTER_ID);

        verify(characterDAO, times(1)).save(deleted);
        Assertions.assertEquals(deleted, result);
    }

    @Test
    public void deleteCharacterNotFoundTest() {
        CharacterData deleted = characterModel;
        deleted.setEnabled(false);

        when(characterDAO.findByCharacterId(CHARACTER_ID)).thenReturn(null);

        Exception exception = Assertions.assertThrows(UnknownIdentifierException.class, () -> characterService.deleteCharacter(CHARACTER_ID));

        String message = exception.getMessage();

        Assertions.assertTrue(message.contains("No character fund with id: " + deleted.getCharacterId()));
    }

    @Test
    public void updateCharacterTest() {
        CharacterData updatedCharacter = characterModel;
        updatedCharacter.setFirstName("NewParseval");

        when(characterDAO.findByCharacterId(CHARACTER_ID)).thenReturn(updatedCharacter);
        when(characterDAO.save(Mockito.any(CharacterData.class))).thenReturn(updatedCharacter);

        CharacterData result = characterService.updateCharacter(updatedCharacter);

        verify(characterDAO, times(1)).save(updatedCharacter);
        Assertions.assertEquals(updatedCharacter, result);
    }

    @Test
    public void updateCharacterTestNoCharacterFound() {
        CharacterData updatedCharacter = characterModel;
        updatedCharacter.setCharacterId(2L);

        when(characterDAO.findByCharacterId(2L)).thenReturn(null);
        when(characterDAO.save(updatedCharacter)).thenReturn(updatedCharacter);

        Exception exception = Assertions.assertThrows(UnknownIdentifierException.class, () -> characterService.updateCharacter(updatedCharacter));

        String thrownMessage = exception.getMessage();

        Assertions.assertTrue(thrownMessage.contains("Failed to get character with id: " + updatedCharacter.getCharacterId()));
    }

    @Test
    public void updateCharacterIdNullTest() {
        CharacterData updatedCharacter = characterModel;
        updatedCharacter.setCharacterId(null);

        when(characterDAO.findByCharacterId(CHARACTER_ID)).thenReturn(updatedCharacter);
        when(characterDAO.save(updatedCharacter)).thenReturn(updatedCharacter);

        Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> characterService.updateCharacter(updatedCharacter));

        String thrownMessage = exception.getMessage();

        Assertions.assertTrue(thrownMessage.contains("Character ID must not be null"));
    }

    @Test
    public void getAllCharactersTest() {
        final List<CharacterData> characterModels = Collections.singletonList(characterModel);
        when(characterDAO.findAll()).thenReturn(characterModels);
        final List<CharacterData> result = characterService.getAllCharacters();
        Assertions.assertEquals(1, result.size());
        Assertions.assertEquals(characterModels, result);
        Assertions.assertEquals(characterModel, result.get(0));
        verify(characterDAO, times(1)).findAll();
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
        when(characterDAO.findByUserUserId(USER_ID, PAGE)).thenReturn(characterModels);
        when(characterDAO.findByUser(userModel)).thenReturn(characterModels);

        final List<CharacterData> resultByUserId = characterService.getAllCharactersByUser(USER_ID);
        final List<CharacterData> resultByUserPageable = characterService.getAllCharactersByUser(USER_ID, PAGE);
        final List<CharacterData> resultByUser = characterService.getAllCharactersByUser(userModel);

        Assertions.assertEquals(1, resultByUserId.size());
        Assertions.assertEquals(characterModels, resultByUserId);
        Assertions.assertEquals(characterModel, resultByUserId.get(0));

        Assertions.assertEquals(1, resultByUser.size());
        Assertions.assertEquals(characterModels, resultByUser);
        Assertions.assertEquals(characterModel, resultByUser.get(0));

        Assertions.assertEquals(1, resultByUserPageable.size());
        Assertions.assertEquals(characterModels, resultByUserPageable);
        Assertions.assertEquals(characterModel, resultByUserPageable.get(0));
    }

    @Test
    public void getAllCharactersByUserNullTest() {
        UserData user = new UserData();
        Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> characterService.getAllCharactersByUser(user));

        String message = exception.getMessage();

        Assertions.assertTrue(message.contains("The user id must not be null nor 0"));
    }

    @Test
    public void getAllCharactersByUserIdNullTest() {
        Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> characterService.getAllCharactersByUser((Long)null));

        String message = exception.getMessage();

        Assertions.assertTrue(message.contains("The user id must not be null nor 0"));
    }

    @Test
    public void getAllCharactersByUserIdNoCharacterFoundTest() {
        when(characterDAO.findByUserUserId(USER_ID)).thenReturn(new ArrayList<>());
        Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> characterService.getAllCharactersByUser(USER_ID));

        String message = exception.getMessage();

        Assertions.assertTrue(message.contains("No character found for user with id: " + USER_ID));
    }

    @Test
    public void getAllCharactersByTable() {
        final List<CharacterData> characterModels = Collections.singletonList(characterModel);

        when(characterDAO.findByTable(Mockito.any(AdventureTableData.class))).thenReturn(characterModels);
        when(characterDAO.findByTable(Mockito.any(AdventureTableData.class), Mockito.any(Pageable.class))).thenReturn(characterModels);
        when(characterDAO.findByTableAdventureTableId(ADVENTURE_TABLE_ID)).thenReturn(characterModels);
        when(characterDAO.findByTableAdventureTableId(ADVENTURE_TABLE_ID, PAGE)).thenReturn(characterModels);

        final List<CharacterData> resultByTable = characterService.getAllCharacterByTable(adventureTableModel);
        final List<CharacterData> resultByTablePageable = characterService.getAllCharacterByTable(adventureTableModel, PAGE);
        final List<CharacterData> resultByTableId = characterService.getAllCharacterByTable(ADVENTURE_TABLE_ID);
        final List<CharacterData> resultByTableIdPageable = characterService.getAllCharacterByTable(ADVENTURE_TABLE_ID, PAGE);

        Assertions.assertEquals(1, resultByTable.size());
        Assertions.assertEquals(characterModels, resultByTable);
        Assertions.assertEquals(characterModel, resultByTable.get(0));

        Assertions.assertEquals(1, resultByTableId.size());
        Assertions.assertEquals(characterModels, resultByTableId);
        Assertions.assertEquals(characterModel, resultByTableId.get(0));

        Assertions.assertEquals(1, resultByTableIdPageable.size());
        Assertions.assertEquals(characterModels, resultByTableIdPageable);
        Assertions.assertEquals(characterModel, resultByTableIdPageable.get(0));

        Assertions.assertEquals(1, resultByTablePageable.size());
        Assertions.assertEquals(characterModels, resultByTablePageable);
        Assertions.assertEquals(characterModel, resultByTablePageable.get(0));
    }

    @Test
    public void getCharacterDAOTest() {
        final CharacterDAO characterDaoTest = characterService.getCharacterDAO();
        Assertions.assertEquals(characterDAO, characterDaoTest);
    }

}

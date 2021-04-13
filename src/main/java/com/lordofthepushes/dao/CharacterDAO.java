package com.lordofthepushes.dao;

import com.lordofthepushes.data.AdventureTableData;
import com.lordofthepushes.data.CharacterData;
import com.lordofthepushes.data.UserData;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("characterDAO")
public interface CharacterDAO extends PagingAndSortingRepository<CharacterData, Long> {
    CharacterData update(CharacterData character);
    CharacterData findByCharacterId(Long characterId);
    List<CharacterData> getAll();
    List<CharacterData> findByUser(UserData userData);
    List<CharacterData> findByUserUserId(Long userId);
    List<CharacterData> findByUserUserId(Long userId, Pageable page);
    CharacterData findByUserUserIdAndFirstName(Long userId, String firstName);
    List<CharacterData> findByTable(AdventureTableData adventureTable);
    List<CharacterData> findByTable(AdventureTableData adventureTable, Pageable page);
    List<CharacterData> findByTableAdventureTableId(Long adventureTableId);
    List<CharacterData> findByTableAdventureTableId(Long adventureTableId, Pageable page);
}

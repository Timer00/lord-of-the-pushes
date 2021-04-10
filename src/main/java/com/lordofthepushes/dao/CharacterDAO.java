package com.lordofthepushes.dao;

import com.lordofthepushes.data.CharacterData;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("characterDAO")
public interface CharacterDAO extends PagingAndSortingRepository<CharacterData, Long> {
    List<CharacterData> findByUserUserId(Long userId);
    List<CharacterData> findByUserUserId(Long userId, Pageable page);
    CharacterData findByUserUserIdAndFirstName(Long userId, String firstName);
}

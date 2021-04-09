package com.lordofthepushes.dao;

import com.lordofthepushes.data.CharacterData;
import com.lordofthepushes.data.UserData;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface CharacterDAO extends PagingAndSortingRepository<CharacterData, Long> {
    Set<CharacterData> findByUser(UserData user);
}

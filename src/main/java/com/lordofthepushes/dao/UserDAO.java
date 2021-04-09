package com.lordofthepushes.dao;

import com.lordofthepushes.data.UserData;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDAO extends PagingAndSortingRepository<UserData, Long> {
}

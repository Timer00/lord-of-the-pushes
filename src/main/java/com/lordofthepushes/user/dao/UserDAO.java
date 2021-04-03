package com.lordofthepushes.user.dao;

import com.lordofthepushes.user.data.UserData;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDAO extends PagingAndSortingRepository<UserData, Integer> {
}

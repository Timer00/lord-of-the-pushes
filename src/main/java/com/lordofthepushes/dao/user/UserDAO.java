package com.lordofthepushes.dao.user;

import com.lordofthepushes.data.UserData;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDAO extends PagingAndSortingRepository<UserData, Integer> {
}

package com.lordofthepushes.dao;

import com.lordofthepushes.data.CountryData;
import com.lordofthepushes.data.UserData;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository("userDAO")
public interface UserDAO extends PagingAndSortingRepository<UserData, Long> {
    List<UserData> findAllByCountry(CountryData country);
    List<UserData> findAllByCountry(CountryData country, Pageable page);
}

package com.lordofthepushes.dao;

import com.lordofthepushes.data.ContinentData;
import com.lordofthepushes.data.CountryData;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CountryDAO extends PagingAndSortingRepository<CountryData, Long> {

    List<CountryData> findByContinent(ContinentData continent, Sort sort);
}

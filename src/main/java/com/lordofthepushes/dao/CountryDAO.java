package com.lordofthepushes.dao;

import com.lordofthepushes.data.ContinentData;
import com.lordofthepushes.data.CountryData;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CountryDAO extends PagingAndSortingRepository<CountryData, Long> {

    CountryData findByCountryId(Long id);
    CountryData findByCountryIsoCode(String iso);
    List<CountryData> findAll();
//    List<CountryData> findAll(Pageable page);
    List<CountryData> findAllByContinent(ContinentData continent);
    List<CountryData> findAllByContinent(ContinentData continent, Pageable page);
}

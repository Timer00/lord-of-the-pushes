package com.lordofthepushes.facades;

import com.lordofthepushes.data.ContinentData;
import com.lordofthepushes.data.CountryData;
import com.lordofthepushes.data.UserData;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CountryFacade {
    CountryData getCountryByISO(String countryIso);
    CountryData getCountryById(Long countryId);
    List<CountryData> findAll();
    Iterable<CountryData> findAll(Pageable page);
    List<UserData> getAllUsersByCountry(CountryData country);
    List<UserData> getAllUsersByCountry(CountryData country, Pageable page);
    List<CountryData> findAllByContinent(ContinentData continent);
    List<CountryData> findAllByContinent(ContinentData continent, Pageable page);
}

package com.lordofthepushes.facades.impl;

import com.lordofthepushes.data.ContinentData;
import com.lordofthepushes.data.CountryData;
import com.lordofthepushes.data.UserData;
import com.lordofthepushes.facades.CountryFacade;
import com.lordofthepushes.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("countryFacade")
public class DefaultCountryFacade implements CountryFacade {

    private CountryService countryService;

    @Override
    public CountryData getCountryByISO(String countryIso) {
        return countryService.getCountryByISO(countryIso);
    }

    @Override
    public CountryData getCountryById(Long countryId) {
        return countryService.getCountryById(countryId);
    }

    @Override
    public List<CountryData> findAll() {
        return countryService.findAll();
    }

    @Override
    public Iterable<CountryData> findAll(Pageable page) {
        return countryService.findAll(page);
    }

    @Override
    public List<UserData> getAllUsersByCountry(CountryData country) {
        return countryService.getAllUsersByCountry(country);
    }

    @Override
    public List<UserData> getAllUsersByCountry(CountryData country, Pageable page) {
        return countryService.getAllUsersByCountry(country, page);
    }

    @Override
    public List<CountryData> findAllByContinent(ContinentData continent) {
        return countryService.findAllByContinent(continent);
    }

    @Override
    public List<CountryData> findAllByContinent(ContinentData continent, Pageable page) {
        return countryService.findAllByContinent(continent, page);
    }

    @Autowired
    public void setCountryService(CountryService countryService) {
        this.countryService = countryService;
    }

    public CountryService getCountryService() {
        return countryService;
    }
}

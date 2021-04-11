package com.lordofthepushes.services.impl;

import com.lordofthepushes.dao.CountryDAO;
import com.lordofthepushes.dao.UserDAO;
import com.lordofthepushes.data.ContinentData;
import com.lordofthepushes.data.CountryData;
import com.lordofthepushes.data.UserData;
import com.lordofthepushes.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("countryService")
public class DefaultCountryService implements CountryService {

    private CountryDAO countryDAO;
    private UserDAO userDAO;

    @Override
    public CountryData getCountryByISO(String countryIso) {
        return countryDAO.findByCountryIsoCode(countryIso);
    }

    @Override
    public CountryData getCountryById(Long countryId) {
        return countryDAO.findByCountryId(countryId);
    }

    @Override
    public List<CountryData> findAll() {
        return countryDAO.findAll();
    }

    @Override
    public Iterable<CountryData> findAll(Pageable page) {
        return countryDAO.findAll(page);
    }

    @Override
    public List<UserData> getAllUsersByCountry(CountryData country) {
        return userDAO.findAllByCountry(country);
    }

    @Override
    public List<UserData> getAllUsersByCountry(CountryData country, Pageable page) {
        return userDAO.findAllByCountry(country, page);
    }

    @Override
    public List<CountryData> findAllByContinent(ContinentData continent) {
        return countryDAO.findAllByContinent(continent);
    }

    @Override
    public List<CountryData> findAllByContinent(ContinentData continent, Pageable page) {
        return countryDAO.findAllByContinent(continent, page);
    }

    @Autowired
    public void setCountryDAO(CountryDAO countryDAO) {
        this.countryDAO = countryDAO;
    }

    public CountryDAO getCountryDAO() {
        return countryDAO;
    }

    @Autowired
    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public UserDAO getUserDAO() {
        return userDAO;
    }
}

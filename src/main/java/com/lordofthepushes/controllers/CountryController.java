package com.lordofthepushes.controllers;

import com.lordofthepushes.dao.CountryDAO;
import com.lordofthepushes.data.ContinentData;
import com.lordofthepushes.data.CountryData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CountryController {

    @Autowired
    private CountryDAO countryDAO;

    @RequestMapping(path = {"/countries"}, method = {RequestMethod.GET})
    public Iterable<CountryData> showAllCountries() {
        return countryDAO.findAll();
    }

    @RequestMapping(path = {"/continents"}, params = {"continent"})
    public Iterable<CountryData> showAllContriesByContinent(@PathVariable ContinentData continentData) {
        return countryDAO.findByContinent(continentData, null);
    }
}

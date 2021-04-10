package com.lordofthepushes.controllers;

import com.lordofthepushes.dao.CountryDAO;
import com.lordofthepushes.data.ContinentData;
import com.lordofthepushes.data.CountryData;
import com.lordofthepushes.facades.CountryFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CountryController {

    private CountryFacade countryFacade;

    @RequestMapping(path = {"/countries"}, method = {RequestMethod.GET})
    public Iterable<CountryData> showAllCountries() {
        return countryFacade.findAll();
    }

    @RequestMapping(path = {"/countries/page/{pageNumber}/{qtdPage}"})
    public Iterable<CountryData> showAllCountriesByContinent(@PathVariable(value = "pageNumber") Integer pageNumber, @PathVariable("qtdPage") Integer qtdPage) {
        if (qtdPage > 5 ) {
            qtdPage = 5;
        }
        if (qtdPage < 1) {
            qtdPage = 1;
        }
        pageNumber = pageNumber >= 1 ? pageNumber - 1 : pageNumber ;
        Pageable page = PageRequest.of(pageNumber, qtdPage);
        return countryFacade.findAll(page);
    }

    @Autowired
    public void setCountryFacade(CountryFacade countryFacade) {
        this.countryFacade = countryFacade;
    }

    public CountryFacade getCountryFacade() {
        return countryFacade;
    }
}

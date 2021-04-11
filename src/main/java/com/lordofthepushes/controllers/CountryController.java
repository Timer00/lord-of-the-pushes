package com.lordofthepushes.controllers;

import com.lordofthepushes.data.ContinentData;
import com.lordofthepushes.data.CountryData;
import com.lordofthepushes.facades.ContinentFacade;
import com.lordofthepushes.facades.CountryFacade;
import com.lordofthepushes.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
public class CountryController {

    private CountryFacade countryFacade;
    private ContinentFacade continentFacade;

    @RequestMapping(path = {"/countries"}, method = {RequestMethod.GET})
    public Iterable<CountryData> showAllCountries() {
        return countryFacade.findAll();
    }

    @RequestMapping(path = {"/countries/page/{pageNumber}/{qtdPage}"})
    public Iterable<CountryData> showAllCountries(@PathVariable(value = "pageNumber") Integer pageNumber, @PathVariable("qtdPage") Integer qtdPage) {
        Pageable page = Util.verifyPageable(pageNumber, qtdPage);
        return countryFacade.findAll(page);
    }

    @RequestMapping(path = {"/countries"}, params = {"continentIso"}, method = {RequestMethod.GET, RequestMethod.POST})
    public Iterable<CountryData> showAllCountriesByContinent(@RequestParam("continentIso") String continentIso) {
        ContinentData continent = continentFacade.findByContinentIsoCode(continentIso);
        return countryFacade.findAllByContinent(continent);
    }

    @RequestMapping(path = {"/countries/page/{pageNumber}/{qtdPage}"}, params = {"continentIso"}, method = {RequestMethod.GET, RequestMethod.POST})
    public Iterable<CountryData> showAllCountriesByContinent(@PathVariable(value = "pageNumber") Integer pageNumber, @PathVariable("qtdPage") Integer qtdPage, @RequestParam("continentIso") String continentIso) {
        ContinentData continent = continentFacade.findByContinentIsoCode(continentIso);
        Pageable page = Util.verifyPageable(pageNumber, qtdPage);
        return countryFacade.findAllByContinent(continent, page);
    }

    @Autowired
    public void setCountryFacade(CountryFacade countryFacade) {
        this.countryFacade = countryFacade;
    }

    @Autowired
    public void setContinentFacade(ContinentFacade continentFacade) {
        this.continentFacade = continentFacade;
    }
}

package com.lordofthepushes.controllers;

import com.lordofthepushes.dao.ContinentDAO;
import com.lordofthepushes.data.ContinentData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContinentController {

    @Autowired
    private ContinentDAO continentDAO;

    @RequestMapping(path = {"/continents"}, method = {RequestMethod.GET})
    public Iterable<ContinentData> showAllCountries() {
        return continentDAO.findAll();
    }
}

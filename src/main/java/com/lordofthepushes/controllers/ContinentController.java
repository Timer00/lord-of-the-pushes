package com.lordofthepushes.controllers;

import com.lordofthepushes.dao.ContinentDAO;
import com.lordofthepushes.data.ContinentData;
import com.lordofthepushes.facades.ContinentFacade;
import com.lordofthepushes.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
public class ContinentController {

    private ContinentFacade continentFacade;

    @RequestMapping(path = {"/continents"}, method = {RequestMethod.GET, RequestMethod.POST})
    public Iterable<ContinentData> showAllContinents() {
        return continentFacade.findAll();
    }

    @RequestMapping(path = {"/continents/pages/{pageNumber}/{qtdPage}"}, method = {RequestMethod.GET, RequestMethod.POST})
    public Page<ContinentData> showAllContinentsPageable(@PathVariable("pageNumber") Integer pageNumber, @PathVariable("qtdPage") Integer qtdPage) {
        Pageable page = Util.verifyPageable(pageNumber, qtdPage);
        return continentFacade.findAll(page);
    }

    @RequestMapping(path = {"/continents"}, params = {"continentIso"}, method = {RequestMethod.GET, RequestMethod.POST})
    public ContinentData getContinentByIso(@RequestParam("continentIso") String continentIso) {
        return continentFacade.findByContinentIsoCode(continentIso);
    }

    @RequestMapping(path = {"/continents"}, params = {"continentName"}, method = {RequestMethod.GET, RequestMethod.POST})
    public ContinentData findContinentByName(){
        return null;
    }
    @Autowired
    public void setContinentFacade(ContinentFacade continentFacade) {
        this.continentFacade = continentFacade;
    }
}

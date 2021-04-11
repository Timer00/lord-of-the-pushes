package com.lordofthepushes.controllers;

import com.lordofthepushes.facades.AdventureTableFacade;
import com.lordofthepushes.data.AdventureTableData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AdventureTableController {
    private AdventureTableFacade adventureTableFacade;

    @RequestMapping(path = {"/adventureTables"}, params = {"adventureTableName"}, method = {RequestMethod.GET, RequestMethod.POST})
    public AdventureTableData findTableByName(@RequestParam("adventureTableName") String name) {
        return adventureTableFacade.findTableByName(name);
    }

    @RequestMapping(path = {"/adventureTables"}, params = {"adventureTableId"}, method = {RequestMethod.GET, RequestMethod.POST})
    public AdventureTableData findTableById(@RequestParam("adventureTableId") Long id) {
        return adventureTableFacade.findTableById(id);
    }

    @RequestMapping(path = {"/adventureTables"}, method = {RequestMethod.GET, RequestMethod.POST})
    public List<AdventureTableData> findAll(){
        return adventureTableFacade.findAll();
    }

    @Autowired
    public void setAdventureTableFacade(AdventureTableFacade adventureTableFacade) {
        this.adventureTableFacade = adventureTableFacade;
    }
}

package com.lordofthepushes.facades.impl;

import com.lordofthepushes.data.AdventureTableData;
import com.lordofthepushes.facades.AdventureTableFacade;
import com.lordofthepushes.services.AdventureTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("adventureTableFacade")
public class DefaultAdventureTableFacade implements AdventureTableFacade {

    private AdventureTableService adventureTableService;

    @Override
    public AdventureTableData findTableByName(String name) {
        return adventureTableService.findTableByName(name);
    }

    @Override
    public AdventureTableData findTableById(Long id) {
        return adventureTableService.findTableById(id);
    }

    @Override
    public List<AdventureTableData> findAll() {
        return adventureTableService.findAll();
    }

    @Autowired
    public void setAdventureTableService(AdventureTableService adventureTableService) {
        this.adventureTableService = adventureTableService;
    }

    public AdventureTableService getAdventureTableService() {
        return adventureTableService;
    }
}

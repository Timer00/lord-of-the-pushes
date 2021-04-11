package com.lordofthepushes.facades.impl;

import com.lordofthepushes.data.ContinentData;
import com.lordofthepushes.facades.ContinentFacade;
import com.lordofthepushes.services.ContinentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("continentFacade")
public class DefaultContinentFacade implements ContinentFacade {

    private ContinentService continentService;

    @Override
    public List<ContinentData> findAll() {
        return continentService.findAll();
    }

    @Override
    public Page<ContinentData> findAll(Pageable page) {
        return continentService.findAll(page);
    }

    @Override
    public ContinentData findContinentByName(String name) {
        return continentService.findContinentByName(name);
    }

    @Override
    public ContinentData findByContinentIsoCode(String iso) {
        return continentService.findByContinentIsoCode(iso);
    }

    @Autowired
    public void setContinentService(ContinentService continentService) {
        this.continentService = continentService;
    }

    public ContinentService getContinentService() {
        return continentService;
    }
}

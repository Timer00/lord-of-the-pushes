package com.lordofthepushes.services.impl;

import com.lordofthepushes.dao.ContinentDAO;
import com.lordofthepushes.data.ContinentData;
import com.lordofthepushes.services.ContinentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

@Service("continentService")
public class DefaultContinentService implements ContinentService {

    private ContinentDAO continentDAO;

    @Override
    public List<ContinentData> findAll() {
        return continentDAO.findAll();
    }

    @Override
    public Page<ContinentData> findAll(Pageable page) {
        return continentDAO.findAll(page);
    }

    @Override
    public ContinentData findContinentByName(String name) {
        Assert.notNull(name, "Continent name must not be null!");
        return continentDAO.findByContinentName(name);
    }

    @Override
    public ContinentData findByContinentIsoCode(String iso) {
        Assert.notNull(iso, "Continent iso must not be null!");
        return continentDAO.findByContinentIsoCode(iso);
    }

    @Autowired
    public void setContinentDAO(ContinentDAO continentDAO) {
        this.continentDAO = continentDAO;
    }

    public ContinentDAO getContinentDAO() {
        return continentDAO;
    }
}

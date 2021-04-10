package com.lordofthepushes.services.impl;

import com.lordofthepushes.dao.ContinentDAO;
import com.lordofthepushes.data.ContinentData;
import com.lordofthepushes.services.ContinentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service("continentService")
public class DefaultContinentService implements ContinentService {

    private ContinentDAO continentDAO;

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

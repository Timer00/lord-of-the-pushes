package com.lordofthepushes.services.impl;

import com.lordofthepushes.dao.AdventureTableDAO;
import com.lordofthepushes.data.AdventureTableData;
import com.lordofthepushes.services.AdventureTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("adventureTableService")
public class DefaultAdventureTableService implements AdventureTableService {

    private AdventureTableDAO adventureTableDAO;

    @Override
    public AdventureTableData findTableByName(String name) {
        return adventureTableDAO.findByTableName(name);
    }

    @Override
    public AdventureTableData findTableById(Long id) {
        return adventureTableDAO.findByAdventureTableId(id);
    }

    @Override
    public List<AdventureTableData> findAll() {
        return adventureTableDAO.findAll();
    }

    @Autowired
    public void setAdventureTableDAO(AdventureTableDAO adventureTableDAO) {
        this.adventureTableDAO = adventureTableDAO;
    }

    public AdventureTableDAO getAdventureTableDAO() {
        return adventureTableDAO;
    }
}

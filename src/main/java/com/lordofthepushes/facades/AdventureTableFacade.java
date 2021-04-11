package com.lordofthepushes.facades;

import com.lordofthepushes.data.AdventureTableData;

import java.util.List;

public interface AdventureTableFacade {
    AdventureTableData findTableByName(String name);
    AdventureTableData findTableById(Long id);
    List<AdventureTableData> findAll();
}

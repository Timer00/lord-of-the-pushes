package com.lordofthepushes.services;

import com.lordofthepushes.data.AdventureTableData;

import java.util.List;

public interface AdventureTableService {
    AdventureTableData findTableByName(String name);
    AdventureTableData findTableById(Long id);
    List<AdventureTableData> findAll();
}

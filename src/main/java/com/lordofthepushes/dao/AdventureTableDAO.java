package com.lordofthepushes.dao;

import com.lordofthepushes.data.AdventureTableData;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdventureTableDAO extends PagingAndSortingRepository<AdventureTableData, Long> {
    AdventureTableData findByTableName(String name);
    AdventureTableData findByAdventureTableId(Long id);
    List<AdventureTableData> findAll();
}

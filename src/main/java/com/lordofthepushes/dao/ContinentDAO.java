package com.lordofthepushes.dao;

import com.lordofthepushes.data.ContinentData;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContinentDAO extends PagingAndSortingRepository<ContinentData, Long> {

    ContinentData findByContinentIsoCode(String isoCode);
    ContinentData findByContinentName(String name);
}

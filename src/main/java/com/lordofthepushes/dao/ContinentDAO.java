package com.lordofthepushes.dao;

import com.lordofthepushes.data.ContinentData;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContinentDAO extends PagingAndSortingRepository<ContinentData, Long> {

    List<ContinentData> findAll();
    Page<ContinentData> findAll(Pageable page);
    ContinentData findByContinentIsoCode(String isoCode);
    ContinentData findByContinentName(String name);
}

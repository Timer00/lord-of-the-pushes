package com.lordofthepushes.services;

import com.lordofthepushes.data.ContinentData;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ContinentService {
    List<ContinentData> findAll();
    Page<ContinentData> findAll(Pageable page);
    ContinentData findContinentByName(String name);
    ContinentData findByContinentIsoCode(String iso);
}

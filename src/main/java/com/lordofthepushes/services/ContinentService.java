package com.lordofthepushes.services;

import com.lordofthepushes.data.ContinentData;

public interface ContinentService {
    ContinentData findContinentByName(String name);
    ContinentData findByContinentIsoCode(String iso);
}

package com.lordofthepushes.facades;

import com.lordofthepushes.data.ContinentData;

public interface ContinentFacade {
    ContinentData findContinentByName(String name);
    ContinentData findByContinentIsoCode(String iso);
}

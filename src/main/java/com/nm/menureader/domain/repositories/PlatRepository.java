package com.nm.menureader.domain.repositories;

import com.nm.menureader.domain.Plat;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface PlatRepository {
    void add(Plat plat);

    Set<Plat> all();

    Optional<Plat> findByName(String name);
}

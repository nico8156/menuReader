package com.nm.menureader.adapters;

import com.nm.menureader.domain.Plat;
import com.nm.menureader.domain.repositories.PlatRepository;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public class InMemoryPlatRepository implements PlatRepository {

    private final Set<Plat> plats = new LinkedHashSet<>();

    public void add(com.nm.menureader.domain.Plat plat) {
        plats.add(plat);
    }

    public Set<Plat> all() {
        return plats;
    }

    public Optional<Plat> findByName(String nom){
        Plat platAComparer = new Plat(nom, 0, null, null);
        return plats.stream()
                .filter(plat -> plat.equals(platAComparer))
                .findFirst();
    }
}

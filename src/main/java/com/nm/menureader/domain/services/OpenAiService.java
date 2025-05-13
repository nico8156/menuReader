package com.nm.menureader.domain.services;

import com.nm.menureader.domain.Plat;

import java.util.List;

public interface OpenAiService {
    List<Plat> genererInfosPlat(List<String> nomsDesPlats);
}

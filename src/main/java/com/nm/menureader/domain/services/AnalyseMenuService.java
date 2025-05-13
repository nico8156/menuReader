package com.nm.menureader.domain.services;
import com.nm.menureader.domain.Plat;
import com.nm.menureader.domain.repositories.PlatRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AnalyseMenuService {

    private final PlatRepository repository;
    private final OpenAiService openAiService;

    public AnalyseMenuService(PlatRepository repository, OpenAiService openAiService) {
        this.repository = repository;
        this.openAiService = openAiService;
    }

    public List<Plat> analyserMenu(List<String> nomsDesPlats) {
        List<Plat> platsFinal = new ArrayList<>();
        List<String> nomsDesPlatsInconnus = new ArrayList<>();

        for (String nom : nomsDesPlats) {
            Optional<Plat> platOpt = repository.findByName(nom);
            if (platOpt.isPresent()) {
                platsFinal.add(platOpt.get());
            } else {
                nomsDesPlatsInconnus.add(nom);
            }
        }
        if(!nomsDesPlatsInconnus.isEmpty()){
            List<Plat> platCree = openAiService.genererInfosPlat(nomsDesPlatsInconnus);
            platCree.forEach(plat -> {
                repository.add(plat);
                platsFinal.add(plat);
            });
        }
        return platsFinal;
    }
}

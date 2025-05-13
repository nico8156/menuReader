package com.nm.menureader.adapters;

import com.nm.menureader.domain.Plat;
import com.nm.menureader.domain.services.OpenAiService;

import java.util.ArrayList;
import java.util.List;

public class FakeOpenAiService implements OpenAiService {
    public List<Plat> genererInfosPlat(List<String> nomsDesPlats){
        List<Plat> platsGeneresAvecInfos = new ArrayList<>();
        nomsDesPlats.forEach(nom -> platsGeneresAvecInfos.add(
                new Plat(
                        nom,
                        400,
                        "impact moyen",
                        "rentabilité moyenne")
        ));
        return platsGeneresAvecInfos;
    };
}

package com.nm.menureader.acceptance;

import com.nm.menureader.domain.Plat;
import com.nm.menureader.domain.repositories.PlatRepository;
import com.nm.menureader.domain.services.AnalyseMenuService;
import com.nm.menureader.domain.services.OpenAiService;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class MenuSteps {

    private final PlatRepository platRepository;
    private AnalyseMenuService analyseMenuService;
    private List<Plat> resultats;

    public MenuSteps(PlatRepository platRepository, OpenAiService openAiService, PlatRepository platRepository1, OpenAiService openAiService1) {

        this.platRepository = platRepository1;
        this.analyseMenuService = new AnalyseMenuService(platRepository, openAiService);
    }
    @Given("les plats existent:")
    public void les_plats_existent_déjà_en_base(DataTable dataTable) {
        List<Map<String, String>> list = dataTable.asMaps(String.class, String.class);
        list.forEach(map -> {
            Plat plat = new Plat(map.get("nom"), Integer.parseInt(map.get("calories")), map.get("impact"), map.get("rentabilite"));
            platRepository.add(plat);
            assertTrue(platRepository.all().contains(plat));
        });
    }
    @Given("le plat {string} n'existe pas encore")
    public void le_plat_n_existe_pas_encore(String nomDuPlat) {
        Optional<Plat> platAChercher = platRepository.findByName(nomDuPlat);
        assertTrue(platAChercher.isEmpty());
    }
    @When("je reçois un menu contenant {string}, {string}, et {string}")
    public void je_reçois_un_menu_contenant(String nomDuPlat1, String nomDuPlat2, String nomDuPlat3) {
        List<String> nomsDesPlats = List.of(nomDuPlat1, nomDuPlat2, nomDuPlat3);
        resultats = analyseMenuService.analyserMenu(nomsDesPlats);
        assertNotNull(resultats, "Nous avons bien une réponse!");
    }
    @Then("je retourne les infos pour {string} et {string} depuis la base")
    public void je_retourne_les_infos_existantes_depuis_la_base(String nom1, String nom2) {
        List<String> nomsAttendus = List.of(nom1, nom2);

        for (String nom : nomsAttendus) {
            //on verifie que le plat est present dans la base par son nom .
            Optional<Plat> platEnBase = platRepository.findByName(nom);
            assertTrue(platEnBase.isPresent(), "Le plat " + nom + " devrait exister dans la base");
            //on verifie que pour chaque nom nous avons bien des infos : calories, impact et rentabilité.
            Plat plat = platEnBase.get();
            assertTrue(Objects.equals(
                    plat.getNom(), "Bolognese") ||
                    Objects.equals(plat.getNom(), "Tartare de saumon"
                    )
            );
            assertTrue(Objects.equals(plat.getCalories(), 450) || Objects.equals(plat.getCalories(), 600));
        }
    }
    @Then("je demande à OpenAI les infos pour {string}")
    public void je_demande_à_open_ai_les_infos_pour(String string) {
        Optional<Plat> platOpt = platRepository.findByName(string);
        assertTrue(platOpt.isPresent());
        Plat plat = platOpt.get();
        assertEquals("Poulet au curry",plat.getNom());
        assertEquals(400,plat.getCalories());
    }

    @Then("j’enregistre {string} et ses données dans la base")
    public void j_enregistre_et_ses_données_dans_la_base(String string) {
        Optional<Plat> platOpt = platRepository.findByName(string);
        assertTrue(platOpt.isPresent());
        assertEquals("Poulet au curry",platOpt.get().getNom());
    }
    @Then("je retourne toutes les infos des trois plats au client")
    public void je_retourne_toutes_les_infos_des_trois_plats_au_client() {
        assertTrue(resultats.size() == 3);
        List<String> nomsAttendus = List.of("Bolognese", "Tartare de saumon", "Poulet au curry");
        List<String> nomsResultats = resultats.stream().map(Plat::getNom).toList();
        assertTrue(nomsResultats.containsAll(nomsAttendus));
    }
}

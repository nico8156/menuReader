Feature: Analyse d’un menu complet envoyé par l'utilisateur
  En tant que backend du système,
  Je veux traiter un menu contenant plusieurs plats
  Afin de fournir des informations pour chaque plat et enrichir la base

  Background:
    Given les plats existent:
      | nom               | calories | impact  | rentabilite |
      | Bolognese         | 600      | moyen   | haute       |
      | Tartare de saumon | 450      | faible  | moyenne     |

  Scenario: Menu contenant un mélange de plats connus et inconnus

    Given le plat "Poulet au curry" n'existe pas encore
    When je reçois un menu contenant "Bolognese", "Tartare de saumon", et "Poulet au curry"
    Then je retourne les infos pour "Bolognese" et "Tartare de saumon" depuis la base
    And je demande à OpenAI les infos pour "Poulet au curry"
    And j’enregistre "Poulet au curry" et ses données dans la base
    And je retourne toutes les infos des trois plats au client
Feature: Validate UI elements on FR credit card application flow

  Scenario: User applies for a Gold American Express card with invalid details
    Given User is on the FR homepage
    When User clicks on "Cartes American Express"
    And User clicks on "En Savoir Plus" for Gold American Express card
    And User clicks on "Demandez Votre Carte"
    And User fills in the application form with invalid details
    And User clicks on "Sauvegarder et Continuer"
    Then User should see a validation error message

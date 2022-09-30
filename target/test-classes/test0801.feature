Feature: test0801

  Background: goes to url
    Given The user goes to url "https://rahulshettyacademy.com/AutomationPractice/"

  Scenario: User selects a radio
    When Select the radio button #1
    Then The radio #1 is selected

  Scenario Outline: User selects a country
    When The user sends a country "<Country>"
    And The user clicks a country
    Then The country selected is "<Country>"

    Examples:
      | Country     |
      | El Salvador |

  Scenario Outline: User selects an option
    When The user selects an option "<Option>"
    Then The option selected is "<Option>"

    Examples:
      | Option  |
      | option2 |
      | option3 |

  Scenario Outline: User clicks on the header buttons
    When The user clicks on the header button "<Button>"
    Then The urls are "<Expected>"

    Examples:
      | Button   | Expected     |
      | Home     | Not the same |
      | Practice | The same     |
      | Login    | The same     |
      | Signup   | The same     |

  Scenario: User opens tabs
    When The user opens the #9 of tabs
    Then The browser has #9 of tabs
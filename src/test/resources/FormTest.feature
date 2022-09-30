Feature: FormTest

  Background: goes to url
    Given The user goes to url "https://demoqa.com/"
    And Remove adds
    And The users clicks on button forms

  Scenario: User selects a button practice form
    When The users clicks on button practice
    Then The url is "https://demoqa.com/automation-practice-form"


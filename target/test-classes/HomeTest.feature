Feature: HomeTest

  Background: goes to url
    Given The user goes to url "https://demoqa.com/"
    And Remove adds

  Scenario: User selects button forms
   When The users clicks on button forms
   Then The url is "https://demoqa.com/forms"


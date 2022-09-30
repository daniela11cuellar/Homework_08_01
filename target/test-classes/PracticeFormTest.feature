Feature: PracticeFormTest

  Background: goes to url
    Given The user goes to url "https://demoqa.com/automation-practice-form"
    And Remove adds

  Scenario Outline: User fills the form
    Given The user fills the form with: "<name>" - "<lastName>" - "<email>" - "<mobile>" - "<subject>" - "<address>"
    And The user selects a gender
    And The user selects a date with day: "20"
    And The user selects a hobby
    #And The user uploads an image with path: "C:\\Users\\user.DESKTOP-0I3ILBP\\Desktop\\" and name: "testing.jpg"
    And The user selects the state: "<state>" and city: "<city>"
    When The form was filled with: "<name>" - "<lastName>" - "<email>" - "<mobile>" - "<subject>" - "<address>"
    And The date are selected
    And The user sends the form
    Then The modal shows the information: "<name>" - "<lastName>" - "<email>" - "<mobile>" - "<subject>" - "<address>"

  Examples:
    | name   | lastName | email                      | mobile     | subject   | address      | state | city  |
    | Robot  | Executor | robot-executor@hotmail.com | 3219790625 | Maths     | Kra 6 A este | NCR   | Delhi |
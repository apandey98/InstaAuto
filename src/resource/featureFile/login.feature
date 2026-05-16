Feature: To Apply jobs online from instahyre
  Scenario: Login successfully
    Given go to url
    When user login
    And user click on login
    Then user select skills
    Then user click on view button
    Then click on Apply

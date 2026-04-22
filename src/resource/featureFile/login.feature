Feature: To Apply jobs online from instahyre
  Scenario: Login with <username> and <password>
    Given go to url
    When user give <username> and <password>
    And user click on login
    Then user select skills


    And go to total jobs feed
    Then user click on view button
    Then click on Apply
    Then wait for 5 seconds
    Then click on apply again
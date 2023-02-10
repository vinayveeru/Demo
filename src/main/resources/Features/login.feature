Feature: feature to test login func

  Scenario: test login

    Given user customer is on login
    When entered credentials
    And when clicks on login btn
    Then user should be taken to dashboard

Feature: Login Test

  Scenario: Validate ProcEzy Login Test


    Given Browser is open

    And user is in Browser
    When User Enters UserName and Password
    And hits login
    Then User Is navigated to Dashboard
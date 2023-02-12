@SmokeTest
Feature: Signup Test

  Scenario: Validate ProcEzy Signup Test


    Given Browser is opened

    And navigate to yopmail
    When enater random string and get mail id
    And open new tab
    Then User Is navigated to procezy
    And enter mail id hit sign up
    Then navigate to yop mail and refresh
    And get otp and store in a variable
    Then navigate to ProcEzy
    And Enter OTP hit enter
    Then fill details

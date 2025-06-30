Feature: New User Registration

  Scenario: Complete registration with valid details
    Given User is on the registration page
    When User enters valid registration details
    And User clicks the register button
    Then A success message or account page should be displayed
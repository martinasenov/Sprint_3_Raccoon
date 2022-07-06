Feature: Fidexio Logout functionality and verifications

  User story:  As a user, I should be able to log out.

  Acceptance Criteria:


  1- User can log out and ends up in login page.

  2- The user can not go to the home page again by clicking the step back button after successfully logged out.


  Background: User is expected to be logged in
    Given the user is logged in



  @FIDEX-499 @LogoutAutomated
  Scenario: 1)Verify that the user can log out and end up in login page
    Given the user is logged in
    When user clicks log out dropdown
    And user clicks log out button
    Then user navigates login page




  @FIDEX-502 @LogoutAutomated
  Scenario: 2)Verify that user can not go to the home page again by clicking the step back button after successfully logged out.
    Given the user is logged in
    When user clicks log out dropdown
    And user clicks log out button
    And user navigates login page
    And user clicks back button
    Then user can not login back and sees "Odoo Session Expired" message
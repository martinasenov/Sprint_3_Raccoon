

Feature: Fidexio Login functionality and verifications

  User story:  As a user, I should be able to log in so that I can land on homepage.

  Acceptance Criteria:

  1-Users can log in with valid credentials (We have 5 types of users but will test only 2 user: PosManager, SalesManager)

  2-"Wrong login/password" should be displayed for invalid (valid username-invalid password and invalid username-valid password) credentials

  3- "Please fill out this field" message should be displayed if the password or username is empty

  4-User land on the ‘reset password’ page after clicking on the "Reset password" link

  5-User should see the password in bullet signs by default

  6- Verify if the ‘Enter’ key of the keyboard is working correctly on the login page.


Background: User is expected to be on the login page
  Given user is on the login page


  @FIDEX-424 @LoginAutomated
  Scenario Outline: 1) Verify that PosManager and SalesManager can log in with the valid credentials
    Given user is on the login page
    When user enters the "<username>" and password "<password>"
    Then user is on the homepage and sees the "<username>" name on the top right
    Examples:
      | username                |  password     |
      | posmanager10@info.com   |  posmanager   |
      | salesmanager15@info.com |  salesmanager |


  @FIDEX-425 @LoginAutomated
  Scenario Outline: 2)Verify that "Wrong login/password" is displayed when valid username and invalid password entered by the both users(PosManager and SalesManager)
    Given user is on the login page
    When user enters an "<invalidUsername>" and valid "<password>"
    Examples:
      | invalidUsername          | password     |
      | invalidUsername@info.com | posmanager   |
      | invalidUsername@info.com | salesmanager |



  @FIDEX-426 @LoginAutomated
  Scenario Outline: 3)Verify that "Wrong login/password" is displayed when invalid username and valid password entered by the both users(PosManager and SalesManager)
    Given user is on the login page
    When user enters a valid "<username>" and "<invalidPassword>"

    Examples:
      | username                | invalidPassword |
      | posmanager10@info.com   | invalidpassword |
      | salesmanager15@info.com | invalidpassword |



  @FIDEX-427 @LoginAutomated
  Scenario: 4)Verify that "Please fill out this field" message is displayed if the password or username is empty.
    Given user is on the login page
    When User don't try to type credentials
    Then user sees the warning message "Please fill out this field."


  @FIDEX-428 @LoginAutomated
  Scenario: 5) Verify that the user lands on the ‘reset password’ page after clicking on the "Reset password" link
    Given user is on the login page
    When user clicks on the -Reset Password- link
    Then user lands on the reset password page

  @FIDEX-429 @LoginAutomated
  Scenario: 6)Verify that the user sees the password in bullet signs by default
    Given user is on the login page
    When user types something in the password field
    Then user sees the characters in bullet sign


  @FIDEX-430 @LoginAutomated
  Scenario Outline: 7)Verify if the ‘Enter’ key of the keyboard is working correctly on the login page.
    Given user is on the login page
    When User enters username "<username>"
    And User enters password "<password>"
    And User presses the Enter key
    Then User should see the home page and username "<username>" on the top right
    Examples: Valid Credentials
      | username | password |
      | salesmanager10@info.com | salesmanager |
      | posmanager10@info.com | posmanager |
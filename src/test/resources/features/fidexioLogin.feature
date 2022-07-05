

Feature: Fidexio Login functionality and verifications

  User story:  As a user, I should be able to log in so that I can land on homepage.

  Acceptance Criteria:

  1-Users can log in with valid credentials (We have 5 types of users but will test only 2 user: PosManager, SalesManager)

  2-"Wrong login/password" should be displayed for invalid (valid username-invalid password and invalid username-valid password) credentials

  3- "Please fill out this field" message should be displayed if the password or username is empty

  4-User land on the ‘reset password’ page after clicking on the "Reset password" link

  5-User should see the password in bullet signs by default

  6- Verify if the ‘Enter’ key of the keyboard is working correctly on the login page.

  Accounts are: PosManager, SalesManager

Background: User is expected to be on the login page
  Given user is on the login page


  Scenario Outline: Users log in with valid credentials
    Given user is on the login page
    When user enters the "<username>" and password "<password>"
    Then user is on the homepage and sees the "<username>" name on the top right
    Examples:
      | username                |   password     |
      | posmanager10@info.com   |   posmanager   |
      | salesmanager15@info.com |   salesmanager |



  Scenario Outline: Users try to log in with invalid user name
    Given user is on the login page
    When user enters an "<invalidUsername>" and valid "<password>"

    Examples:
      | invalidUsername        |   password     |
      | pomanager10@info.com   |   posmanager   |
      | salemanager15@info.com |   salesmanager |


  Scenario Outline: Users try to log in with invalid password
    Given user is on the login page
    When user enters a valid "<username>" and "<invalidPassword>"

    Examples:
      | username               |   invalidPassword |
      | pomanager10@info.com   |   posmanager      |
      | salemanager15@info.com |   salesmanager    |

  @wip
  Scenario : The user clicks on the login button with leaving username or password field or both.
    Given user is on the login page
    When user leaves the username or password or both fields empty and clicks login button
    Then user sees the warning message -Please fill out this field-

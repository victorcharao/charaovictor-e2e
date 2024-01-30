#language: en

Feature: Login to Application

  Background:
    Given that the user accesses the login page

  Scenario: Login with valid credentials
    And send a valid username
    And send a valid password
    When login form is submitted
    Then the user is logged into the application
    And seeing home page

  Scenario Template: Login with invalid credentials
    And send invalid username "<username>"
    And send invalid password "<password>"
    When login form is submitted
    Then the user is not logged into the application
    And an "<error message>" is displayed

    Examples:
      | username        | password     | error message                                                             |
      | user            |  pass        | Epic sadface: Username and password do not match any user in this service |
      | user            |              | Epic sadface: Password is required                                        |
      |                 |  pass        | Epic sadface: Username is required                                        |
      | locked_out_user | secret_sauce | Epic sadface: Sorry, this user has been locked out.                       |

  Scenario: Access a secret url without login
    When navigate to a secret url
    Then the user is not logged into the application
    And is still seeing the login page
    And a error message is displayed
Feature: Login Functionality

  Scenario Outline: Valid login
    Given I open the login page
    When I enter "<email>" and "<password>"
    Then I should land on the account page

    Examples:
      | email                        | password   |
      | CMbonani@inspiredtesting.com | Dumisani@2 |

  Scenario Outline: Invalid login
    Given I open the login page
    When I enter "<email>" and "<password>"
    Then I should see "<error_message>"

    Examples:
      | email                        | password      | error_message                                         |
      | WrongEmail@gmail.com         | Dumisani@2    | Warning: No match for E-Mail Address and/or Password. |
      | CMbonani@inspiredtesting.com | Wrongpassword | Warning: No match for E-Mail Address and/or Password. |


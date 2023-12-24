
Feature: User login

  Scenario: user logs in successfully
    Given that the user is not logged in
    When  email is a "dana@gmail.com"
    And password is a "12345"
    Then the user logs in successfully



  Scenario: user entered wrong email or password
    Given that the user is not logged in
    When  email is a "danaa@gmail.com"
    And password is a "12356584"
    Then the user will not login


  Scenario: user doesn't entered email or password
    Given that the user is not logged in
    When  email is a "danaa@gmail.com"
    And password is a ""
    Then the user will not login


  Scenario: user chooses log out
    Given the user is logged in
    Then the user will return to the welcome page
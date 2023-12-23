Feature: User login

  Scenario Outline: user logs in successfully
    Given the user is not logged in
    When email is <email>
    And password is <password>
    Then the user logs in successfully

    Examples:
      | email             | password |
      | 'dana@gmail.com'  | '12345'  |
      | 'leema@gmail.com' | '00000'  |

  Scenario Outline: user entered wrong email or password
    Given the user is not logged in
    When  email is <email>
    And password is <password>
    Then the user will not login
    And show a message why he can't login

    Examples:
      | email             | password |
      | 'danaa@gmail.com' | '123459' |
      | 'leema@gmail.com' | '000001' |


  Scenario Outline: user doesn't entered email or password
    Given that the user is not logged in
    When  email is <email>
    And password is <password>
    Then the user will not login
    And show a message why he can't login

    Examples:
      | email             | password |
      | 'danaa@gmail.com' | ' '      |

  Scenario: user chooses log out
    Given the user is logged in
    Then the user will return to the welcome page


Feature: user signs up

  Scenario Outline: user sign up successfully
    Given that the user is not signed up
    When  email is <email>
    And password is <password>
    And username is <username>
    And type is <Type>
    And location is <location>
    And phoneNum is <phoneNum>
    Then the user will sign up and added to userslist


    Examples:
      | username | email             | password | Type        | location | phoneNum     |
      | 'laith'  | 'laith@gmail.com' | '123456' | 'Installer' | 'qal'    | '0258963242' |


  Scenario Outline: user failed to sign up
    Given that the user is not signed up
    When  email is <email>
    And password is <password>
    And username is <username>
    And type is <Type>
    And location is <location>
    And phoneNum is <phoneNum>
    Then the user will not sign up
    And show why can't sign up

    Examples:
      | username | email            | password | Type        | location | phoneNum   |
      | 'danaa'  | 'dana@gmail.com' | '85269'  | 'Installer' | 'nab'    | '05896321' |

  Scenario Outline: user failed to sign up
    Given that the user is not signed up
    When  email is <email>
    And password is <password>
    And username is <username>
    And type is <Type>
    And location is <location>
    And phoneNum is <phoneNum>
    Then the user will not sign up
    And show why can't sign up

    Examples:
      | username | email           | password | Type        | location | phoneNum   |
      | 'danaa'  | 'danagmail.com' | '85269'  | 'Installer' | 'nab'    | '05896321' |

  Scenario Outline: user failed to sign up
    Given that the user is not signed up
    When  email is <email>
    And password is <password>
    And username is <username>
    And type is <Type>
    And location is <location>
    And phoneNum is <phoneNum>
    Then the user will not sign up
    And show why can't sign up

    Examples:
      | username | email             | password | Type        | location | phoneNum   |
      | 'danaa'  | 'ahmad@gmail.com' | '22'     | 'Installer' | 'nab'    | '05896321' |

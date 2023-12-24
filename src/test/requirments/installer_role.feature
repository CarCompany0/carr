Feature: installer tasks

  Scenario: : View installation requests.
    Given the user is installer
    When the user chooses "View installation requests."
    Then the installation requests appears.



  Scenario: schedule appointments.
    Given the user is installer
    And the  customer  email is "saleh@gmail.com"
    And the  customer  pass is "11111"
    When  the installer choose "2"
    And   the day "03"
    And  the mounth "09"
    And  the year "2023"
    And  the hour "5:20"
    Then The new appointment Added succsesfully

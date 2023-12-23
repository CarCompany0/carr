Feature: Notifications

  Scenario: Customer receives an order confirmation and updates
    Given the user is a customer
    And the user is in Browse  Products Page
    And the user has placed an order of product "2"
    And the quantity "2"
    And the availabelity is "true"
    Then an email is to be sent to "dana29454@gmail.com"

  Scenario: Installer recives new installation request
    Given the user is a customer
    When The customer enters product name is "camera"
    And the  customer  current email is "leema@gmail.com"
    And the  customer  password is "00000"
    And the installer date is "3"
    Then an email will be sent to "s12029320@stu.najah.edu"
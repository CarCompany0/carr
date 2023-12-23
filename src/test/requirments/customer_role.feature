
Feature: Customer Role

  Scenario: Successfully buying accessories
    Given  the user is customer
    When The customer enters product number "2"
    And the customer  enters "2" of the quantity of that accessories
    And the Availabelity is "true"
    Then the Customer buys it succsesfully

  Scenario: Failed buy accessories due to Availabelity
    When The customer enters product number "3"
    And the customer  enters "4" of the quantity of that accessories
    And the Availabelity is "false"
    Then the customer will not buy it

  Scenario: view orders
    Given  the user is customer
    When The customer choose "view orders"
    Then show the history of his orders

  Scenario: search for product
    Given  the user is customer
    When The customer choose "search for a product"
    When The customer enter the name of product "backseat cover"
    Then print all information about this product

  Scenario: Browse products
    Given  the user is customer
    When The customer choose "Browse products"
    Then show the product list

  Scenario: Edit Profile
    Given  the user is customer

    When The customer choose "Edit Profile"
    And the  customer  email "leema@gmail.com"
    And the  customer  pass "00000"
    And the new customer  username "leema"
    And the new customer  email "leema@gmail.com"
    And the new customer  password "00000"
    And the new customer  location "qalqiliah"
    And the new customer  phonenumber "0231456889"
    Then The information Succsesfully

  Scenario: Failed Edit Profile
    Given  the user is customer
    When The customer choose "Edit Profile"
    And the  customer  email "leema@gmail.com"
    And the  customer  pass "00000"
    And the new customer  username "leema"
    And the new customer  email "dana@gmail.com"
    And the new customer  password "00000"
    And the new customer  location "qalqiliah"
    And the new customer  phonenumber "0231456889"
    Then The information failed to update

  Scenario: Request Installation
    Given  the user is customer
    When The customer enters product name "camera"
    And the  customer  email "leema@gmail.com"
    And the  customer  pass "00000"
    And the installer date "3"
    Then The installation will be requested





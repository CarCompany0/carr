Feature: Admin tasks

  Scenario Outline: add products
    Given that the user is an admin
    When the type is <type>
    And the name is <name>
    And the des is <des>
    And the image is <image>
    And the price is <price>
    And availablity is <availablity>
    Then The product is added successfully

    Examples:
      | type       | name   | des   | image | price | availablity |
      | 'Interior' | 'name' | 'des' | 'url' | '50$' | 'true'      |

  Scenario Outline: cant add product due to left blanks
    Given that the user is an admin
    When the type is <type>
    And the name is <name>
    And the des is <des>
    And the image is <image>
    And the price is <price>
    And availablity is <availablity>
    Then The product is failed to add

    Examples:
      | type       | name   | des   | image | price | availablity |
      | 'Interior' | 'name' | 'des' | 'url' | '50$' | ''          |

  Scenario Outline: fail to update product/category due to left blanks
    Given that the user is an admin
    When Product num <numProduct>
    When the type is <type>
    And the name is <name>
    And the des is <des>
    And the image is <image>
    And the price is <price>
    And availablity is <availablity>
    Then the product/category is failed to Update
    Examples:
      | numProduct | type | name | des   | image | price | availablity |
      | '3'        | ''   | ''   | 'des' | ''    | '50$' | 'true'      |

  Scenario Outline: update product/category
    Given that the user is an admin
    When Product num <numProduct>
    When the type is <type>
    And the name is <name>
    And the des is <des>
    And the image is <image>
    And the price is <price>
    And availablity is <availablity>
    Then the product/category is Updated successfully in the list
    Examples:
      | numProduct | type       | name   | des   | image | price | availablity |
      | '2'        | 'Interior' | 'name' | 'des' | 'url' | '50$' | 'true'      |

  Scenario Outline: update product By Name
    Given that the user is an admin
    When Product name <oldName>
    When the type is <type>
    And the name is <name>
    And the des is <des>
    And the image is <image>
    And the price is <price>
    And availablity is <availablity>
    Then the product is Updated successfully in the list
    Examples:
      | oldName  | type       |  | name   | des   | image | price | availablity |
      | 'camera' | 'Interior' |  | 'name' | 'des' | 'url' | '50$' | 'true'      |

  Scenario Outline: remove product By Name
    Given that the user is an admin
    When Product name <oldName>
    Then the product is Deleted successfully in the list
    Examples:
      | oldName |
      | 'tint'  |


  Scenario Outline:  admin enter wrong product number to update product
    Given that the user is an admin
    When Product num <numProduct>
    Then product is failed to update
    Examples:
      | numProduct |
      | '15'       |

  Scenario Outline:  admin enter wrong product number to delete product
    Given that the user is an admin
    When Product num <numProduct>
    Then product is failed to delete
    Examples:
      | numProduct |
      | '15'       |

  Scenario Outline: An admin deletes products
    Given that the user is an admin
    When Product num <numProduct>
    Then The product is deleted successfully from the list
    Examples:
      | numProduct |
      | '2'        |

  Scenario Outline: admin deletes category
    Given that the user is an admin
    When Category name <typee>
    Then The category is deleted successfully from the list
    Examples:
      | typee      |
      | 'Interior' |

  Scenario Outline: admin fails to deletes category
    Given that the user is an admin
    When Category name <typee>
    Then The category is failed to delete
    Examples:
      | typee |
      | 'EX'  |


  Scenario: update user information.
    Given that the user is an admin
    When  usernum "4"
    When the username is "saleh"
    And the location is "india"
    And the phonenumber is "05649875"
    Then The User information will be Updated successfully

  Scenario: faild to update user information.
    Given that the user is an admin
    When  usernum "20"
    When the username is "saleh"
    And the location is "india"
    And the phonenumber is "05649875"
    Then The User information will not be Updated


  Scenario Outline: delete User Account
    Given that the user is an admin
    When usernum <numUser>
    Then The Account deleted successfully
    Examples:
      | numUser |
      | '2'     |

  Scenario Outline: faild to delete User Account
    Given that the user is an admin
    When usernum <numUser>
    Then The Account will not deleted
    Examples:
      | numUser |
      | '20'    |

  Scenario: can search for product
    Given  that the user is an admin
    When The customer enter the name of product is "tint"
    Then print all details about this product

  Scenario: can view accounts
    Given  that the user is an admin
    When The admin choose to "View Acounts"
    Then print all accounts

  Scenario: can search for Category
    Given  that the user is an admin
    When The customer enter the name of Category "Exterior"
    Then print all products that have the same category

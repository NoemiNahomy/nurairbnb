@Metodopago
Feature: Perform a item creation

  Scenario: Perform item creation with valid details
    Given an item with valid details
      | id      | f36c3228-190f-469b-9d28-8ffebbef4596    |
      | detalle      | tarjeta |
      | tipo      | T |
    When request is submitted for item creation
    Then verify that the Item HTTP response is 200
    And a item id is returned
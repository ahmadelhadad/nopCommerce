Feature: Create successful Order
  Background: user open Browser and login to site
    Given user login with "asaas@gmail.com" and "123456"
  Scenario: Create successful Order
    When user add item to cart and click on shoppingCart icon
    And click on Checkout button
    And user add Checkout valid data "ahmad" "elhadad" "asaas@gmail.com" "Egypt" "Giza" "asd" "123" "123" and click continue button
    And continue shipping method
    And continue payment method
    And continue payment information
    And user confirm order
    Then success Message appear

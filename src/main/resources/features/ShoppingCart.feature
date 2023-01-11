@regression
Feature: Logged user could add different products to Shopping cart

  Background: Logged user could add different products to Shopping cart
    Given user navigate to Login pageSCa
    And user Login with "asaas@gmail.com" and "123456"

    Scenario: user could add different products to Shopping cart
      When user click on add to cart button and be redirected to the product page
      And user click on add to cart button
      Then Flash msg Should appear
      And the added product exists in shopping cart

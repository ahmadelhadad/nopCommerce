@regression
Feature: Logged user could add different products to Wishlist

  Background: Logged user could add different products to Wishlist
    Given user navigate to Login pageW
    And user Login to site with "asaas@gmail.com" and "123456"

    Scenario: user could add different products to Wishlist
      When user click on add to wishlist button and be redirected to the product page
      And user click on add to wishlist button
      Then Flash message should appear
      And the added product exists in Wishlist

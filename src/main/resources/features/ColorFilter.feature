@regression
Feature: Logged user could filter with color
  Background: user open Browser and navigate to login page
    Given user navigate to login pageCF "asaas@gmail.com" and "123456"
    And user navigate to Category Apparel and Shoes

    Scenario: Logged user could filter with color
      When user choose color randomly
      Then items appear
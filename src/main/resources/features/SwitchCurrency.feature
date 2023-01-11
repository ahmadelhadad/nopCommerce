@regression
Feature: Logged User could switch between currencies US-Euro

  Background: user open Browser and navigate to home page
    Given user navigate to login PageSC
    And user type "asaas@gmail.com" and "123456" and press login button

    Scenario: Logged User could switch between currencies Euro
      When user choose currency from the drop down list "Euro"
      Then items price will be converted to the new currency
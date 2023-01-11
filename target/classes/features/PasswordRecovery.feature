@regression
Feature: User could reset his password successfully

Background: user open Browser and navigate to register page
Given user navigate to password recovery page

  Scenario: user will recover password
    When user enter his email "asaas@gmail.com"
    And click recover Button
    Then success recover
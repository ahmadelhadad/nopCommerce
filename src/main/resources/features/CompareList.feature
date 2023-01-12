@regression
Feature: Logged user could add different products to CompareList
  Background: Logged user could add different products to CompareList
    Given user navigate to Login pageCL
    And user Login with "asaas@gmail.com" and "123456" to site

  Scenario: Logged user could add different products to CompareList
    When user click on add to CompareList button
    And Success message will appear and user click on CompareList icon
    Then item exist in CompareList page
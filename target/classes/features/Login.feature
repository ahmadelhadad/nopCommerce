@regression
Feature: User could log in with valid email and password

Background: navigate to login page
  Given user navigate to login pageL
  #Test scenario 1
  Scenario: user will login with valid email and password
    When user enter "asaas@gmail.com" and "123456" and press login button
    #Expected Result
    Then user could login successfully and go to main page

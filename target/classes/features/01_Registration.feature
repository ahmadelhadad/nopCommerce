@regression
Feature: User could register with valid data

  Background: user open Browser and navigate to register page
    Given user navigate to register page

    Scenario: user will register with valid data
      When user choose gender
      And user enter firstName "ahmad"
      And user enter lastName "elhadad"
      And user enter date "1" and "may" and "1999"
      And user enter email "asaas@gmail.com"
      And user enter companyName "NA"
      And user enter password "123456"
      And user enter confirmation password "123456"
      And user press register button

      Then user could register successfully
      And user go to register result page
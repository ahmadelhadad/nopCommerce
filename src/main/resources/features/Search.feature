@regression
  Feature: Logged User could search for any product

    Background: user open Browser and navigate to home page
      Given user navigate to login pages
      And user enter "asaas@gmail.com" and "123456" and press login buttonS

      Scenario: Logged User could search for any product
        When user type search data and click search button "apple"
        Then user redirected to search page
        And user search items appear
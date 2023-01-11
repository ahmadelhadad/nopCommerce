@regression
Feature:Logged user could select different tags
  Background: user open Browser and navigate to login page
    Given user navigate to login pageDT "asaas@gmail.com" and "123456"
    And navigate to category

  Scenario: Logged user could select different tags
    When user select Tag
    Then user should be redirected to the tag page and items with the same tag should be displayed
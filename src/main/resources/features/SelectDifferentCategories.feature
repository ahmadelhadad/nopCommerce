@regression
Feature:Logged user could select different Categories
  Background: user open Browser and navigate to login page
    Given user navigate to login pageSD "asaas@gmail.com" and "123456"

  Scenario: Logged user could select different Categories
    When User hover on one of the categories
    And user select one of the subCategories to View
    Then Page title must be same as the selected category
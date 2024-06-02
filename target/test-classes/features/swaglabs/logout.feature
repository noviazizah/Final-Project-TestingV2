Feature: Logout

  Scenario: Successful Logout
    Given I am logged in to the application
    When I click on the menu button
    And I click on the logout button
    Then I should be redirected to the login page
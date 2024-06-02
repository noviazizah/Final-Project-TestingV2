Feature: Login

  Scenario: Successful login with valid username and password
    Given I am on the SauceDemo login page
    When I enter username "standard_user" and password "secret_sauce"
    And I click the login button
    Then I should be redirected to the products page

  Scenario: Unsuccessful login with invalid username and password
    Given I am on the SauceDemo login page
    When I enter username "invalid_user" and password "invalid_password"
    And I click the login button
    Then I should see an error message "Username and password do not match any user in this service !"

  Scenario: Unsuccessful login with valid username and invalid password
    Given I am on the SauceDemo login page
    When I enter username "standard_user" and password "invalid_password"
    And I click the login button
    Then I should see an error message "Username and password do not match any user in this service !"

  Scenario: Unsuccessful login with invalid username and valid password
    Given I am on the SauceDemo login page
    When I enter username "invalid_user" and password "secret_sauce"
    And I click the login button
    Then I should see an error message "Username and password do not match any user in this service !"

  Scenario: Unsuccessful login with only username
    Given I am on the SauceDemo login page
    When I enter username "standard_user" and password ""
    And I click the login button
    Then I should see an error message "You need Password !"

  Scenario: Unsuccessful login with only password
    Given I am on the SauceDemo login page
    When I enter username "" and password "secret_sauce"
    And I click the login button
    Then I should see an error message "You need Username !"

  Scenario: Unsuccessful login with no username and no password
    Given I am on the SauceDemo login page
    When I enter username "" and password ""
    And I click the login button
    Then I should see an error message "You need Username & Password !"

Feature: Login to Swag Labs

  Background:
    Given I navigate to the 'Log-in' page
    And the field 'Username' is empty
    And the field 'password' is empty

  Scenario: Login successfully
    When I type 'standard_user' in the 'email' field
    And I type 'secret_sauce' in 'password'
    And I click the 'Login' button
    Then the title 'Swag labs' is displayed

  Scenario: Unable to login with a locked user
    When I type 'locked_out_user' in the 'email' field
    And I type 'secret_sauce' in 'password'
    When I click the 'Login' button
    Then field 'username' should show an error
    And field 'password' should show an error
    And the error message 'Epic sadface: Sorry, this user has been locked out.' is displayed

  Scenario: Wrong password
    When I type 'standard_user' in the 'email' field
    And I type '123456' in 'password'
    When I click the 'Login' button
    Then field 'username' should show an error
    And field 'password' should show an error
    And the error message 'Epic sadface: Username and password do not match any user in this service' is displayed

  Scenario: No username is provided
    When I type 'secret_sauce' in 'password'
    When I click the 'Login' button
    Then field 'username' should show an error
    And field 'password' should show an error
    And the error message 'Epic sadface: Username is required' is displayed

  Scenario: No password is provided
    When I type 'standard_user' in the 'email' field
    When I click the 'Login' button
    Then field 'username' should show an error
    And field 'password' should show an error
    And the error message 'Epic sadface: Password is required' is displayed

Feature: Login to Swag Labs

  Background:
    Given I navigate to the 'Log-in' page
    And the field 'email' is empty
    And the field 'password' is empty

  Scenario: Login successfully
    When I type 'standard_user' in the 'email' field
    And I type 'secret_sauce' in 'password'
    And I click the 'Login' button
    Then the title 'Swag labs' is displayed

  Scenario: Error on empty fields
    When I click the 'Login' button
    Then field 'email' should be with error
    And field 'password' should be with error

  Scenario: Wrong password
    When I type 'john.test@keepfy.com' in 'email'
    And I type '123456' in 'password'
    And I click on 'enter'
    Then I should see 'E-mail or password is incorrect'

  Scenario: Login successfully
    Given I have users:
      | name           | email             | password |
      | Vitor Batista  | vitor@keepfy.com  | abcdef   |
    When I type 'vitor@keepfy.com' in 'email'
    And I type 'abcdef' in 'password'
    And I click on 'enter'
    Then I shouldn't see 'Access your account'
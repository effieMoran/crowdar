Feature: Shopping Cart - Positive test cases

  Background:
    Given I am logged-in into 'Swag labs' with a 'standard_user'

  Scenario: Verify that the shopping cart icon is displayed
    Then the shopping cart icon is displayed

  Scenario: Verify that the shopping cart icon is clickable
    Then the shopping cart icon is enabled

  Scenario: Verify the shopping cart page UI should be as expected
    When I click the shopping cart icon
    Then I am redirected to the 'cart.html' page
    And the 'Your cart' secondary title is displayed

  Scenario: Verify that the user is able to add items into the cart or not
    When I click the 'Add to cart' button on the item number '1'
    And I click the 'Add to cart' button on the item number '4'
    Then the shopping cart icon should display the number '2'

  Scenario: Verify that the user is able to add items into the cart icon number increases
    When I click the 'Add to cart' button on the item number '1'
    And click the 'Add to cart' button on the item number '4'
    Then the shopping cart icon should display the number '2'

  Scenario: Verify if the user decreases the number of items then the cart icon decreases its number
    When I click the 'Add to cart' button on the item number '1'
    And I click the 'Add to cart' button on the item number '4'
    And I click the 'Add to cart' button on the item number '5'
    Then the shopping cart icon should display the number '3'
    When I click the 'Remove' button on the item number '1'
    Then the shopping cart icon should display the number '2'

  Scenario:Verify that when the user clicks on the cart button then the user should navigate to the shopping cart page with the selected products
    When I click the 'Add to cart' button on the item number '1'
    And I click the 'Add to cart' button on the item number '4'
    And I click the 'Add to cart' button on the item number '5'
    When I click the 'Shopping cart' icon
    And Then I am redirected to the 'cart.html' page
    Then the item number '1' is present
    And the item number '4' is present
    And the item number '5' is present

  Scenario:Verify that when the user clicks on the cart button then the user should navigate to the shopping cart page with the selected products
    When I click the 'Add to cart' button on the item number '1'
    And I click the 'Add to cart' button on the item number '4'
    And I click the 'Add to cart' button on the item number '5'
    When I click the 'Shopping cart' icon
    And Then I am redirected to the 'cart.html' page
    Then the item number '1' is present
    And the item number '4' is present
    And the item number '5' is present

  Scenario:Verify that the user is able to remove items from the cart
    When I click the 'Add to cart' button on the item number '1'
    And I click the 'Add to cart' button on the item number '4'
    And I click the 'Add to cart' button on the item number '5'
    And I click the 'Shopping cart' icon
    And  I am redirected to the 'cart.html' page
    When I click the remove button on the item number '1'
    Then the item number '1' is not displayed

  Scenario:Verify the checkout button is enabled
    When I click the 'Add to cart' button on the item number '1'
    And I click the 'Add to cart' button on the item number '4'
    And I click the 'Add to cart' button on the item number '5'
    And I click the 'Shopping cart' icon
    And  I am redirected to the 'cart.html' page
    When I click the 'Checkout' button
    Then I am redirected to 'checkout-step-one.html' page


  Scenario:Verify if the user can go back to shopping with products on the cart
    When I click the 'Add to cart' button on the item number '1'
    And I click the 'Add to cart' button on the item number '4'
    And I click the 'Add to cart' button on the item number '5'
    And I click the 'Shopping cart' icon
    And  I am redirected to the 'cart.html' page
    When I click the 'Continue Shopping' button
    Then I am redirected to 'inventory.html' page

  Scenario:Verify if the user can go back to shopping without products on the cart
    And I click the 'Shopping cart' icon
    And  I am redirected to the 'cart.html' page
    When I click the 'Continue Shopping' button
    Then I am redirected to 'inventory.html' page

  Scenario: Verify the maximum number of items can be added to the cart
    When I click the 'Add to cart' button on all the items
    And I click the 'Shopping cart' icon
    And  I am redirected to the 'cart.html' page
    When All the items are displayed

  Scenario: Verify if adding the maximum number of items is shown in the shopping cart icon
    When I click the 'Add to cart' button on all the items
    Then the shopping cart icon should display the total number of products

  Scenario: Verify if adding the maximum number of items is shown in the shopping cart icon
    When I click the 'Add to cart' button on all the items
    Then the shopping cart icon should display the total number of products

  Scenario: Verify that each item price is the same on the shopping cart page
    When I click the 'Add to cart' button on the item number '1'
    And I click the 'Add to cart' button on the item number '4'
    And I click the 'Add to cart' button on the item number '5'
    When I click the 'Shopping cart' icon
    And  I am redirected to the 'cart.html' page
    Then the item number '1' should have the same price
    Then the item number '4' should have the same price
    Then the item number '5' should have the same price

  Scenario: Verify that when the user removes some items from the cart and goes back to shopping the products are not selected anymore
    When I click the 'Add to cart' button on the item number '1'
    And I click the 'Add to cart' button on the item number '4'
    And I click the 'Add to cart' button on the item number '5'
    When I click the 'Shopping cart' icon
    And  I am redirected to the 'cart.html' page
    And I click the 'Remove' button on the item number '1'
    When I click the 'Continue Shopping' button
    Then I am redirected to 'inventory.html' page
    And the item number '1' displays the button 'Add to cart'

  Scenario: Verify that when the user removes some items from the cart and goes back to shopping the remaining products are still selected
    When I click the 'Add to cart' button on the item number '1'
    And I click the 'Add to cart' button on the item number '4'
    And I click the 'Add to cart' button on the item number '5'
    When I click the 'Shopping cart' icon
    And  I am redirected to the 'cart.html' page
    And I click the 'Remove' button on the item number '1'
    When I click the 'Continue Shopping' button
    Then I am redirected to 'inventory.html' page
    And the item number '4' displays the button 'Remove'
    And the item number '5' displays the button 'Remove'
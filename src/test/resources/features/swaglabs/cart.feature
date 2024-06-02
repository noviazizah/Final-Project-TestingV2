Feature:  Cart
  Background: I am logged in.
    Scenario: As a user, I want to add items to the shopping cart
      Given I am on the products page
      When  I click the "Add To Cart" button next to an item
      Then  the item is added to cart

    Scenario: As a user I want to see the contents of my shopping cart
      Given I'm on the products page
      When I click on the cart icon
      Then I want to see the products in my shopping cart

    Scenario: As a user I want to see the details of the items in my shhopping cart
    Given I've added an item to the cart
    When I am on the cart page
    Then I want to see the details of the products in my shopping cart

    Scenario: As a user, I want to remove an item from the cart from the products page
      Given I am on the products page with items in the cart
      When I click the remove button in the products page
      Then Remove item from cart

    Scenario: As a user, I want to remove an item from the cart from the cart inventory page
      Given I am on the cart inventory page with there are item in the cart
      When I click the remove button in the cart inventory page
      Then Remove item from cart


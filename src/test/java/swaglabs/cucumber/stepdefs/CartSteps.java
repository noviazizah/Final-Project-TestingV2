package swaglabs.cucumber.stepdefs;

import swaglabs.pom.model.Product;
import swaglabs.pom.pages.CartPage;
import swaglabs.pom.pages.LoginPage;
import swaglabs.pom.pages.ProductsPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

public class CartSteps {
    private WebDriver webDriver;
    private String description;
    private ProductsPage productsPage;
    private LoginPage loginPage;
    private StepDefManager manager;
    private CartPage cartPage;
    private By bagInfo = new By.ByClassName("inventory_item_desc");
    private List<String> itemDescInCart;
    private int numOfItemsInCart;
    private int newNumOfItemsInCart;
    List<String> expectedItemDescription;

    public CartSteps(StepDefManager manager) {
        this.manager = manager;
    }

    // Add to cart
    @Given("I am on the products page")
    public void iAmOnTheProductsPage() {
        loginPage = new LoginPage(manager.getWebDriver());
        loginPage.login("standard_user", "secret_sauce");
        productsPage = loginPage.getRedirect();
    }

    @When("I click the \"Add To Cart\" button next to an item")
    public void iClickTheButtonNextToAnItem() {
        productsPage.addBagToCart();
        description = productsPage.getBackpackDescription();
    }

    @Then("the item is added to cart")
    public void theItemIsAddedToCart() {
        cartPage = productsPage.goToCart();
        itemDescInCart = cartPage.getDescOfItemsInCart();
        Assertions.assertTrue(itemDescInCart.contains(description));
    }

    // Remove from cart
    @Given("I am on the products page with items in the cart")
    public void iAmOnTheProductsPageWithItemsInTheCart() {
        loginPage = new LoginPage(manager.getWebDriver());
        loginPage.login("standard_user", "secret_sauce");
        productsPage = loginPage.getRedirect();
        productsPage.addBagToCart();
    }

    @Given("I am on the cart inventory page with there are item in the cart")
    public void iAmOnTheCartInventoryPageWithThereAreItemInTheCart() {
        loginPage = new LoginPage(manager.getWebDriver());
        loginPage.login("standard_user", "secret_sauce");
        productsPage = loginPage.getRedirect();
        productsPage.addBagToCart();
        cartPage = productsPage.goToCart();
    }

    @When("I click the remove button in the products page")
    public void iClickTheRemoveButtonInTheProductsPage() {
        numOfItemsInCart = productsPage.numberOfItemsInCart();
        productsPage.removeBackpackFromCartWhenOnProductsPage();
    }

    @When("I click the remove button in the cart inventory page")
    public void iClickTheRemoveButtonInTheCartInventoryPage() {
        numOfItemsInCart = cartPage.numberOfItemsInCart();
        cartPage.removeBackpackFromCartWhenOnCartPage();
    }

    @Then("Remove item from cart")
    public void removeItemFromCart() {
        numOfItemsInCart--;
        newNumOfItemsInCart = productsPage.numberOfItemsInCart();
        Assertions.assertEquals(numOfItemsInCart, newNumOfItemsInCart);
    }

    // View cart
    @Given("I'm on the products page")
    public void imOnTheProductsPage() {
        loginPage = new LoginPage(manager.getWebDriver());
        loginPage.login("standard_user", "secret_sauce");
        productsPage = loginPage.getRedirect();
    }

    @When("I click on the cart icon")
    public void iClickOnTheCartIcon() {

        productsPage.goToCart();
    }

    @Then("I want to see the products in my shopping cart")
    public void iWantToSeeTheCorrectProductsInMyShoppingCart() {
        String actualUrl = manager.getPageURL();
        Assertions.assertEquals("https://www.saucedemo.com/cart.html", actualUrl);
    }

    @Given("I've added an item to the cart")
    public void iVeAddedAnItemToTheCart() {
        loginPage = new LoginPage(manager.getWebDriver());
        loginPage.login("standard_user", "secret_sauce");
        productsPage = loginPage.getRedirect();
        productsPage.addBagToCart();
        productsPage.addTShirt();
        expectedItemDescription = productsPage.getBackpackAndTshirtInfo();
    }

    @When("I am on the cart page")
    public void iAmOnTheCartPage() {
        cartPage = productsPage.goToCart();
    }

    @Then("I want to see the details of the products in my shopping cart")
    public void iWantToSeeTheDetailsOfTheProductsInMyShoppingCart() {
        List<String> actualResults = cartPage.getDescOfItemsInCart();
        Assertions.assertTrue(actualResults.equals(expectedItemDescription));
    }
}

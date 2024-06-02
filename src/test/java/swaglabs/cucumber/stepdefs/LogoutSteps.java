package swaglabs.cucumber.stepdefs;

import swaglabs.pom.pages.LoginPage;
import swaglabs.pom.pages.ProductsPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertEquals;

public class LogoutSteps {

    private StepDefManager manager;
    private LoginPage loginPage;
    private ProductsPage productsPage;

    public LogoutSteps(StepDefManager manager) {
        this.manager = manager;
    }

    @Given("I am logged in to the application")
    public void iAmLoggedInToTheApplication() {
        loginPage = new LoginPage(manager.getWebDriver());
        manager.getWebDriver().get("https://www.saucedemo.com/");
        loginPage.fillWithUsername("standard_user");
        loginPage.fillWithPassword("secret_sauce");
        loginPage.submit();
        productsPage = new ProductsPage(manager.getWebDriver());
    }

    @When("I click on the menu button")
    public void iClickOnTheMenuButton() {
        productsPage.clickMenuButton();
    }

    @And("I click on the logout button")
    public void iClickOnTheLogoutButton() {
        productsPage.clickLogoutButton();
    }

    @Then("I should be redirected to the login page")
    public void iShouldBeRedirectedToTheLoginPage() {
        assertEquals("https://www.saucedemo.com/", manager.getPageURL());
    }
}

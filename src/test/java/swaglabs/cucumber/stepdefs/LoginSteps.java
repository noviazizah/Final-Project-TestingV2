package swaglabs.cucumber.stepdefs;

import swaglabs.pom.pages.LoginPage;
import swaglabs.pom.pages.ProductsPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LoginSteps {

    private StepDefManager manager;
    private LoginPage loginPage;

    public LoginSteps(StepDefManager manager) {
        this.manager = manager;
    }

    @Given("I am on the SauceDemo login page")
    public void iAmOnTheSauceDemoLoginPage() {
        loginPage = new LoginPage(manager.getWebDriver());
        manager.getWebDriver().get("https://www.saucedemo.com/");
    }

    @When("I enter username {string} and password {string}")
    public void iEnterUsernameAndPassword(String username, String password) {
        loginPage.fillWithUsername(username);
        loginPage.fillWithPassword(password);
    }

    @And("I click the login button")
    public void iClickTheLoginButton() {
        loginPage.submit();
    }

    @Then("I should be redirected to the products page")
    public void iShouldBeRedirectedToTheProductsPage() {
        assertEquals("https://www.saucedemo.com/inventory.html", manager.getPageURL());
    }

    @Then("I should see an error message {string}")
    public void iShouldSeeAnErrorMessage(String expectedErrorMessage) {
        assertTrue(loginPage.getError().contains(expectedErrorMessage));
    }
}

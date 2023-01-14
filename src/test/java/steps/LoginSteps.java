package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LoginSteps {

    LoginPage page = new LoginPage();
    private static final String URL_LOGIN_PAGE = "https://www.saucedemo.com/";
    private static final String URL_HOME_PAGE = URL_LOGIN_PAGE + "inventory.html";
    private static final String ACCESS_NOT_ALLOWED_ERROR_MESSAGE =  "Epic sadface: You can only access '/inventory.html' when you are logged in.";

    @Given("that the user accesses the login page")
    public void accessLoginPage() {
        page.navigateTo(URL_LOGIN_PAGE);
    }

    @Given("send a valid username")
    public void sendValidUser() {
        page.typeUsername("standard_user");
    }

    @Given("send a valid password")
    public void sendValidPassword() {
        page.typePassword("secret_sauce");
    }

    @When("login form is submitted")
    public void submitLoginForm() {
        page.submitLoginForm();
    }

    @Then("the user is logged into the application")
    public void expectUserLoggedIn() {
        assertEquals(URL_HOME_PAGE, page.getCurrentUrl());
    }

    @Then("seeing home page")
    public void expectUserSeeingHomePage() {
        assertTrue(page.isElementDisplayed(".primary_header"));
        assertTrue(page.isElementDisplayed(".header_secondary_container"));
        assertTrue(page.isElementDisplayed(".inventory_container"));
        assertTrue(page.isElementDisplayed(".footer"));
    }

    @Given("send invalid username {string}")
    public void sendInvalidUsername(String username) {
        page.typeUsername(username);
    }

    @Given("send invalid password {string}")
    public void sendInvalidPassword(String username){
        page.typePassword(username);
    }

    @Then("the user is not logged into the application")
    public void expectUserNotLoggedIn() {
        assertEquals(URL_LOGIN_PAGE, page.getCurrentUrl());
    }

    @Then("an {string} is displayed")
    public void expectErrorMessage(String errorMessage) {
        assertEquals(errorMessage, page.getErrorMessageText());
    }

    @When("navigate to a secret url")
    public void navigateToSecretUrl() {
        page.navigateTo(URL_HOME_PAGE);
    }

    @Then("is still seeing the login page")
    public void expectUserIsSeeingLoginPage() {
        assertTrue(page.isElementDisplayed(".login-box"));
        assertTrue(page.isElementDisplayed(".bot_column"));
    }

    @Then("a error message is displayed")
    public void expectAccessNotAllowedErrorMessage() {
        assertEquals(ACCESS_NOT_ALLOWED_ERROR_MESSAGE, page.getErrorMessageText());
    }
}

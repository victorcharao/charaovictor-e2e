package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;

import static mappings.home.HomeMappings.*;
import static mappings.login.LoginMappings.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static static_data.static_data.*;

public class LoginSteps {

    LoginPage page = new LoginPage();

    @Given("that the user accesses the login page")
    public void accessLoginPage() {
        page.navigateTo(URL_LOGIN_PAGE);
    }

    @Given("send a valid username")
    public void sendValidUser() {
        page.typeUsername(USERNAME);
    }

    @Given("send a valid password")
    public void sendValidPassword() {
        page.typePassword(PASSWORD);
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
        assertTrue(page.areElementsDisplayed(
                COMPONENT_HEADER_CONTAINER,
                COMPONENT_HEADER_SECONDARY_CONTAINER,
                COMPONENT_INVENTORY_CONTAINER,
                COMPONENT_FOOTER));
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
        assertTrue(page.isElementDisplayed(LOGIN_BOX));
    }

    @Then("a error message is displayed")
    public void expectAccessNotAllowedErrorMessage() {
        assertEquals(ACCESS_NOT_ALLOWED_ERROR_MESSAGE, page.getErrorMessageText());
    }
}

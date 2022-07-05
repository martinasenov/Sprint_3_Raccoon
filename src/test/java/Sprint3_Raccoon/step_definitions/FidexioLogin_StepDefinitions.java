package Sprint3_Raccoon.step_definitions;

import Sprint3_Raccoon.pages.FidexioLoginPage;
import Sprint3_Raccoon.utilites.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.Locale;

public class FidexioLogin_StepDefinitions {

    FidexioLoginPage fidexioLoginPage = new FidexioLoginPage();

    @Given("user is on the login page")
    public void user_is_on_the_login_page() {
        Driver.getDriver().get("https://qa.fidexio.com/ ");
    }


    @When("user enters the {string} and password {string}")
    public void user_enters_the_and_password(String username, String password) {
        fidexioLoginPage.usernameField.sendKeys(username);
        fidexioLoginPage.passwordField.sendKeys(password);
        fidexioLoginPage.loginButton.click();

    }

    @Then("user is on the homepage and sees the {string} name on the top right")
    public void user_is_on_the_homepage_and_sees_the_name_on_the_top_right(String username) {

        Assert.assertTrue(username.substring(0, username.lastIndexOf("@")).contains(fidexioLoginPage.accountName.getText().toLowerCase(Locale.ROOT)));
    }


    @When("user enters an {string} and valid {string}")
    public void user_enters_an_and_valid(String username, String password) {

        fidexioLoginPage.usernameField.sendKeys(username);
        fidexioLoginPage.passwordField.sendKeys(password);
        fidexioLoginPage.loginButton.click();
    }


    @When("user enters a valid {string} and {string}")
    public void user_enters_a_valid_and(String username, String password) {


        fidexioLoginPage.usernameField.sendKeys(username);
        fidexioLoginPage.passwordField.sendKeys(password);
        fidexioLoginPage.loginButton.click();


    }


    @When("User don't try to type credentials")
    public void userDonTTryToTypeCredentials() {

        fidexioLoginPage.loginButton.click();
    }

    @Then("user sees the warning message {string}")
    public void userSeesTheWarningMessage(String arg0) {

        System.out.println(fidexioLoginPage.usernameField.getAttribute("validationMessage"));
    }
}














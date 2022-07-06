package Sprint3_Raccoon.step_definitions;

import Sprint3_Raccoon.pages.FidexioLoginPage;
import Sprint3_Raccoon.utilites.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.awt.*;
import java.security.Key;
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
    public void userIsOnTheHomepageAndSeesTheNameOnTheTopRight(String arg0) {
        Assert.assertTrue(arg0.substring(0, arg0.lastIndexOf("@")).contains(fidexioLoginPage.accountName.getText().toLowerCase(Locale.ROOT)));
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


        Assert.assertEquals(fidexioLoginPage.usernameField.getAttribute("validationMessage"),arg0);
    }



    @When("user clicks on the -Reset Password- link")
    public void userClicksOnTheResetPasswordLink() {

     fidexioLoginPage.resetPassword.click();

    }

    @Then("user lands on the reset password page")
    public void userLandsOnTheResetPasswordPage() {

        Assert.assertTrue(Driver.getDriver().getCurrentUrl().equals("https://qa.fidexio.com/web/reset_password?"));
    }




    @When("user types something in the password field")
    public void userTypesSomethingInThePasswordField() {
        fidexioLoginPage.passwordField.sendKeys("password");
    }

    @Then("user sees the characters in bullet sign")
    public void userSeesTheCharactersInBulletSign() {
        Assert.assertTrue(fidexioLoginPage.passwordField.getAttribute("type").equals("password"));
    //if the type equals to "password" it is masked (in bullet signs), if it is text, it's not masked
        //in this case it is masked
    }




    @When("User enters username {string}")
    public void userEntersUsername(String username) {

        fidexioLoginPage.usernameField.sendKeys(username);

    }

    @And("User enters password {string}")
    public void userEntersPassword(String password) {
        fidexioLoginPage.passwordField.sendKeys(password);
    }

    @And("User presses the Enter key")
    public void userPressesTheEnterKey() {

        fidexioLoginPage.passwordField.sendKeys(Keys.ENTER);
    }

    @Then("User should see the home page and username {string} on the top right")
    public void userShouldSeeTheHomePageAndUsernameOnTheTopRight(String username) {

        Assert.assertTrue(username.substring(0, username.lastIndexOf("@")).contains(fidexioLoginPage.accountName.getText().toLowerCase(Locale.ROOT)));
    }



}














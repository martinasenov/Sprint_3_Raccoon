package Sprint3_Raccoon.step_definitions;

import Sprint3_Raccoon.pages.FidexioLoginPage;
import Sprint3_Raccoon.utilites.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

public class FidexioLogout_StepDefinitions {

    FidexioLoginPage fidexioLoginPage = new FidexioLoginPage();

    @Given("the user is logged in")
    public void theUserIsLoggedIn() {
        Driver.getDriver().get("https://qa.fidexio.com/");
        fidexioLoginPage.usernameField.sendKeys("posmanager10@info.com");
        fidexioLoginPage.passwordField.sendKeys("posmanager");
        fidexioLoginPage.loginButton.click();
    }

    @When("user clicks log out dropdown")
    public void userClicksLogOutDropdown() {

        fidexioLoginPage.accountName.click();

    }

    @And("user clicks log out button")
    public void userClicksLogOutButton() {
        fidexioLoginPage.logoutButton.click();
    }

    @Then("user navigates login page")
    public void userNavigatesLoginPage() {

        Assert.assertEquals(Driver.getDriver().getCurrentUrl(),"https://qa.fidexio.com/web/login");

    }

    @Then("user clicks back button")
    public void userClicksBackButton() {

        Driver.getDriver().navigate().back();
    }


    @Then("user can not login back and sees {string} message")
    public void userCanNotLoginBackAndSeesMessage(String arg0) {

        Assert.assertEquals(fidexioLoginPage.sessionExpiredMessage.getText(),arg0);


    }
}

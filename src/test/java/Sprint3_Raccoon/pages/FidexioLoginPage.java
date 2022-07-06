package Sprint3_Raccoon.pages;

import Sprint3_Raccoon.utilites.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FidexioLoginPage {

 public FidexioLoginPage(){PageFactory.initElements(Driver.getDriver(),this);}


 @FindBy(id="login")
 public WebElement usernameField;


 @FindBy(id="password")
 public WebElement passwordField;


 @FindBy(xpath="//button[@type='submit']")
 public WebElement loginButton;

 @FindBy(xpath="//*[@class='oe_topbar_name']")
 public WebElement accountName;

 @FindBy(xpath= "//*[@class='btn btn-link pull-right']")
 public WebElement resetPassword;


 @FindBy(xpath = "//*[@class='dropdown-menu']//li//a[@data-menu='logout']")
 public WebElement logoutButton;


 @FindBy(xpath = "//*[@class='modal-header']//h4[@class='modal-title']")
 public WebElement sessionExpiredMessage;

}

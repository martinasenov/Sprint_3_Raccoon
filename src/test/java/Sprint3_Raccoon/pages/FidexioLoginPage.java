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


}

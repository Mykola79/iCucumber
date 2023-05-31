package PagesFactory;

import StepDefinitions.PageInitializer;
import Utils.CommonMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPracticePage extends CommonMethods {

    @FindBy(id = "txtUsername")
    public WebElement sendingUser;


    @FindBy(id = "txtPassword")
    public WebElement sendingPassword;

    @FindBy(id = "btnLogin")
    public WebElement loginBtn;


    @FindBy(id = "welcome")
    public WebElement welckAdm;

    @FindBy(xpath = "//a[text()='Logout']")
    public WebElement logOutBtnn;


    public LoginPracticePage(){

        PageFactory.initElements(driver,this);
    }
}

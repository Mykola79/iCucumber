package StepDefinitions;

import Utils.CommonMethods;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginScenarioOutline1 extends CommonMethods {

    @Given("open the browser and launch HRMS applicationnn")
    public void open_the_browser_and_launch_hrms_applicationnn() {

        openBrowser();
    }



    @When("user eneters valid {string} and {string}")
    public void user_eneters_valid_and(String username, String password) {
        sendText(login.usernameTextBox,username);
        sendText(login.passwordTextBox,password);




    }
    @When("user clics loginn")
    public void user_clics_loginn() {

        doClick(login.loginBtn);


    }
    @Then("user is loggged in successfully {string}")
    public void user_is_loggged_in_successfully(String string) {

        if(login.welcomeIcon.isDisplayed()){
            Assert.assertEquals(string,login.welcomeIcon);
        }

    }
}

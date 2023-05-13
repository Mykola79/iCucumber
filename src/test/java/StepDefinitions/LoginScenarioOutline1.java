package StepDefinitions;

import Utils.CommonMethods;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginScenarioOutline1 extends CommonMethods {

    @Given("open the browser and launch HRMS applicationnn")
    public void open_the_browser_and_launch_hrms_applicationnn() {

        openBrowser();
    }



    @When("user eneters valid {string} and {string}")
    public void user_eneters_valid_and(String username, String password) {



    }
    @When("user clics loginn")
    public void user_clics_loginn() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("user is loggged in successfully")
    public void user_is_loggged_in_successfully() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
}

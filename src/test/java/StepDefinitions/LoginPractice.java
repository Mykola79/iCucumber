package StepDefinitions;

import Utils.CommonMethods;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;
import java.util.Map;

public class LoginPractice extends CommonMethods {

    @Given("open the browser and launch HRMS applicationn")
    public void open_the_browser_and_launch_hrms_applicationn() {

        openBrowser();
    }


    @When("user enters username and password and verifies logins")
    public void user_enters_username_and_password_and_verifies_logins(DataTable dataTable1) {



        List<Map<String, String>> userCredentials = dataTable1.asMaps();

        for (Map<String, String> userCreds : userCredentials) {
            String username = userCreds.get("username");
            String password = userCreds.get("password");

            sendText(loginPracticePage.sendingUser, username);
            sendText(loginPracticePage.sendingPassword, password);

            doClick(loginPracticePage.loginBtn);


            doClick(loginPracticePage.welckAdm);
            //doClick(loginPracticePage.logOutBtnn);



            /*List<Map<String, String>> userCredentials = dataTable.asMaps();

            for (Map<String, String> userCreds : userCredentials) {
                String username = userCreds.get("username");
                String password = userCreds.get("password");

                sendText(login.usernameTextBox, username);
                sendText(login.passwordTextBox, password);

                doClick(login.loginBtn);


                doClick(login.welcomeIcon);
                doClick(login.logoutLink);*/
        }
    }
}
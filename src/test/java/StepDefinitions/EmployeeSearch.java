package StepDefinitions;

import Utils.CommonMethods;
//import Utils.ConfigReader;
import Utils.ConfigReader;
import io.cucumber.java.en.When;

public class EmployeeSearch extends CommonMethods {

    @When("user enters valid employee id")
    public void user_enters_valid_employee_id() {

        //WebElement empIdTextBox=driver.findElement(By.id("empsearch_id"));
        //sendText(employeeSearchPage.empIdTextBox, PropertyReader.getPropertyValue("empid"));
        sendText(employeeSearchPage.empIdTextBox, ConfigReader.getPropertyValue("empid"));

    }
    @When("Clicks on search button")
    public void clicks_on_search_button() {

        //WebElement searchButton=driver.findElement(By.id("searchBtn"));
        doClick(employeeSearchPage.searchButton);

    }
    @When("user see employee information is displayed")
    public void user_see_employee_information_is_displayed() {
        System.out.println("The employee is displayed");

    }
    @When("user select Job Title")
    public void user_select_job_title() {

        //WebElement jobTitleDdl = driver.findElement(By.id("empsearch_job_title"));
        selectByOptions(employeeSearchPage.jobTitleDdl, "Singer");

        //WebElement EmpStatusDdl = driver.findElement(By.id("empsearch_employee_status"));
        selectByOptions(employeeSearchPage.EmpStatusDdl, "Active");

        //WebElement includeDdl= driver.findElement(By.id("empsearch_termination"));
        selectByOptions(employeeSearchPage.includeDdl, "Current and Past Employees");
    }
}
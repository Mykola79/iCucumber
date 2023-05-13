package StepDefinitions;

import Utils.CommonMethods;
import io.cucumber.java.en.Given;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class DeleteEmployee {


    @Given("open browser and launch HRMS application2")
    public void open_browser_and_launch_hrms_application2() {
        WebDriver driver = new ChromeDriver();

        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");

        driver.findElement(By.id("txtUsername")).sendKeys("admin");
        driver.findElement(By.id("txtPassword")).sendKeys("Hum@nhrm123");
        driver.findElement(By.id("btnLogin")).click();

        driver.findElement(By.id("menu_pim_viewPimModule")).click();
        driver.findElement(By.id("menu_pim_viewEmployeeList")).click();

        boolean isFound = false;
        while (!isFound) {
            List<WebElement> table = driver.findElements(By.xpath("//table[@id='resultTable']/tbody/tr/td[2]"));


            for (int i = 1; i < table.size(); i++) {
                String table1 = table.get(i).getText();

                if (table1.equalsIgnoreCase("50911A")) {
                    WebElement row = driver.findElement(By.xpath("//table[@id='resultTable']/tbody/tr[" + (i + 1) + "]/td[1]"));
                    row.click();
                    isFound = true;

                }
            }
            if(!isFound) {
                driver.findElement(By.xpath("//a[text()='Next']")).click();

           }
        }
    }
}
package StepDefinitions;

import Utils.CommonMethods;
import Utils.ConfigReader;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.util.List;

public class PickADate extends CommonMethods {

    @When("user clicks on DATE webelemnt")
    public void user_clicks_on_date_webelemnt() {

        doClick(pickADatePage.clickOnward);
    }

    @When("picks a month month")
    public void picks_a_month_month() {


        boolean isFound = false;
        while (!isFound) {
            //WebElement monthPicker = driver.findElement(By.xpath("//td[@class ='monthTitle']"));
            String monthPicker2 = pickADatePage.monthDate.getText();
            String monthPicker3[] = monthPicker2.split(" ");
            if (monthPicker3[0].equalsIgnoreCase(ConfigReader.getPropertyValue("month")) && monthPicker3[1].equalsIgnoreCase(ConfigReader.getPropertyValue("year"))) {
                //List<WebElement> dayPicker = driver.findElements(By.xpath("//table[@class='rb-monthTable first last']/tbody/tr/td"));

                for (WebElement dayPicker2 : pickADatePage.dayPicker) {
                    String dayPicker3 = dayPicker2.getText();

                    if (dayPicker3.equalsIgnoreCase(ConfigReader.getPropertyValue("day"))) {
                        dayPicker2.click();
                        isFound=true; break;

                    }

                }
            }
        else{driver.findElement(By.xpath("//td[@class='next']")).click();
            }
        }
    }
}

/*

     driver.findElement(By.xpath("//input[@id='onward_cal']")).click();

    boolean isFound=false;
        while(!isFound){
        WebElement montYear=driver.findElement(By.xpath("//td[@class='monthTitle']"));
        String montYear2=montYear.getText();
        String montYear3[]=montYear2.split(" ");

        if(montYear3[0].equalsIgnoreCase(month) && montYear3[1].equalsIgnoreCase(year)){

            List<WebElement> days=driver.findElements(By.xpath("//table[@class='rb-monthTable first last']//tr/td"));

            for (WebElement day1:days){

                if(day1.getText().equalsIgnoreCase(day)){
                    day1.click();isFound=true;
                }
            }
        }else{driver.findElement(By.xpath("//td[@class='next']")).click();
        }*/


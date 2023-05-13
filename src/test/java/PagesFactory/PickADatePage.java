package PagesFactory;

import Utils.CommonMethods;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class PickADatePage extends CommonMethods {


    @FindBy(id = "onward_cal")
    public WebElement clickOnward;

    @FindBy(xpath = "//td[@class ='monthTitle']")
    public WebElement monthDate;

    @FindBy(xpath = "//table[@class='rb-monthTable first last']/tbody/tr/td")
    public List<WebElement> dayPicker;





    public PickADatePage(){
        PageFactory.initElements(driver,this);

    }
}






    /*String url = "https://www.redbus.in/";
        driver.get(url);
        driver.manage().window().maximize();

    String month = "Aug";
    String day = "19";
    String year = "2023";



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



package corplabSelenium.testsel;


import corplabSelenium.utilites.WebDriverFac;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class Tsk_Selenium {

    public static void main(String[] args) {

//        1.	Start the test by opening a browser to www.labcorp.com

        WebDriver driver = WebDriverFac.getDriver("chrome");
        driver.manage().window().maximize();

        // go to labcorp.com

        driver.navigate().to("https://www.labcorp.com/");

//        2.	Find and click Careers link

//        driver.findElement(By.linkText("class=\"no-ext ext\"")).click(); we can use like that or

        WebElement careeersLink = driver.findElement(By.xpath("(//a[contains(text(),'Careers')])[1]"));
        careeersLink.click();


        List<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));


//        3.	Search for any position (that is currently active on the site) example “QA Test Automation Developer”

//      4.	Select and browse to the position

        WebElement search = driver.findElement(By.xpath("//input[@au-target-id='162']"));
        search.sendKeys("QA Test Automation Developer" + Keys.ENTER);

//
//        5.	Add assertions to confirm
        //        a.	Job Title

        WebElement jobTitle = driver.findElement(By.xpath("(//span[contains(text(),'QA Test Automation Developer ')])[1]"));

        assertEquals(jobTitle.getText().trim(),"QA Test Automation Developer");





//        b.	Job Location

        WebElement jobLocation = driver.findElement(By.xpath("(//span[contains(text(),'Location')])[1]"));

        assertEquals(jobLocation.getText().trim(),"Durham, North Carolina, United States of America");
//        c.	Job Id

        WebElement jobID = driver.findElement(By.xpath("(//span[contains(text(),'21-90223_RM')])[1]"));

        assertEquals(jobID.getText().trim(),"21-90223_RM");

//        d.	Any 3 other assertions of your choice (could be text in the requirements / introduction)
//        Example: (Text in quotes “” from below example should be updated by candidate to match that in the position chosen for the automation solution):
//
//•	Confirm first sentence of third paragraph under Description/Introduction as “The right candidate for this role will participate in the test automation technology development and best practice models.”
//•	Confirm second bullet point under Management Support as “Prepare test plans, budgets, and schedules.”
//•	Confirm third requirement as “5+ years of experience in QA automation development and scripting.”
//•	Confirm first suggested automation tool to be familiar with contains “Selenium”
//        6.	Click Apply Now and confirm Job Title, Job Location, Job ID and another text of choice to match the previous page in the proceeding page.


        List<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(2));


        WebElement clickTab = driver.findElement(By.xpath("(//span[contains(text(),'QA Test Automation Developer ')])[1]"));
        clickTab.click();


//        7.	Click to Return to Job Search




    }
}

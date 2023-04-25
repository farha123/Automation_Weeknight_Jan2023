package Day13_04172023;

import Reusable_Library.ReusableActions;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class T1_ExtentReport_Yahoo {
    //declare global webdriver variable
    WebDriver driver;
    //define extent report
    ExtentReports reports;
    //extent logger
    ExtentTest logger;


    @BeforeSuite
    public void setUpChromeDriver() {
        //declare the web driver and define it from the reusable actions
        driver = ReusableActions.setUpDriver();
        reports = new ExtentReports("src/main/java/HTML_Report/Automation_Report.html", true);
    }//end of before class
    @Test
    public void tc001_verifyStaySignInOptionIsChecked() {
        //set the name of the test case to the report
        logger = reports.startTest("tc001_verifyStaySignInOptionIsChecked");
        //navigate to yahoo.com
        driver.navigate().to("https://www.yahoo.com");
        //next we need to click on the sign in button
        ReusableActions.clickAction(driver, "//*[text() = 'Sign in']", "SignInButton");
        //pass logger info for informative text
        logger.log(LogStatus.INFO, "successfully clicked on the sign in button");
        //verify the stay signed in option is checked
        boolean isStaySignedInChecked = driver.findElement(By.xpath("//*[@id = 'persistent']")).isSelected();
        //the actual validation of our test
        //if the checkbox is checked then we pass the test
        //or else we fail the test
        if (isStaySignedInChecked == true) {
            logger.log(LogStatus.PASS, "The checkbox is checked: " + isStaySignedInChecked);
        } else {
            logger.log(LogStatus.FAIL, "The checkbox is checked: " + isStaySignedInChecked);
        }
        reports.endTest(logger);
    }//end of test case 1

    @AfterSuite
    public void quitDriverSession() {
        driver.quit();
        //needed to create the html report after test execution
        reports.flush();
    }//end of after suite
}//end of class

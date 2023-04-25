package Day12_04112023;

import Reusable_Library.ReusableActions;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.lang.reflect.Method;

public class TestParent {
    //set all global variables with public static
    //private variables can not be accessed by the child classes
    public static WebDriver driver;
    //define the extent report variables
    public static ExtentReports reports;
    //extent logger
    public static ExtentTest logger;

    @BeforeSuite
    public void setUpChromeDriver() {
        //declare the web driver and define it from the reusable actions
        driver = ReusableActions.setUpDriver();
        reports = new ExtentReports("src/main/java/HTML_Report/Automation_Report.html", true);
    }//end of before class

    @BeforeMethod
    public void setTestName(Method methodName){
        //set the name of the test case to the report using logger concept
        logger = reports.startTest(methodName.getName());
    }
    @AfterMethod
    public void endTest(){
        reports.endTest(logger);
    }
    @AfterSuite
    public void quitDriverSession() {
        driver.quit();
        //needed to create the html report after test execution
        reports.flush();
    }//end of after suite
}//end of parent class(base class)

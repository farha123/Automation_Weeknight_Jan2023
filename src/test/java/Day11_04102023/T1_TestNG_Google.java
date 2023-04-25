package Day11_04102023;

import Reusable_Library.ReusableActions;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class T1_TestNG_Google {
    //declare global webdriver variable
    WebDriver driver;

    @BeforeSuite
    public void setUpChromeDriver() {
        //declare the webdriver and define it from the reusable actions
        driver = ReusableActions.setUpDriver();
    }//end of before class

    @Test(priority = 1)
    public void searchForACar() {
        //go to google page
        driver.navigate().to("https://www.google.com");
        //enter a car in the search field
        ReusableActions.sendKeysAction(driver, "//*[@name='q']", "BMW", "SearchField");
        //hit submit on the google search button
        ReusableActions.submitAction(driver, "//*[@name='btnK']", "GoogleSubmit");
    }//end of test case 1

    @Test(priority = 2)
    public void captureSearchResult() {
        String result = ReusableActions.getText(driver, "//*[@id='result-stats']", "SearchResult");
        String[] arrayResult = result.split(" ");
        System.out.println("Result is " + arrayResult[1]);
    }//end of test case 2

    @AfterSuite
    public void quitDriverSession() {
        driver.quit();
    }//end of after suite
}

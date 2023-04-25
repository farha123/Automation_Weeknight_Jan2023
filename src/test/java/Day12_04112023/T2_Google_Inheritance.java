package Day12_04112023;

import Reusable_Library.ReusableActions;
import org.testng.annotations.Test;

import static Day12_04112023.TestParent.driver;

public class T2_Google_Inheritance extends TestParent {

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
}//end of test class (child class)

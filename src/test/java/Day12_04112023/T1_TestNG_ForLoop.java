package Day12_04112023;

import Reusable_Library.ReusableActions;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class T1_TestNG_ForLoop {
    //declare global webdriver variable
    WebDriver driver;

    @BeforeSuite
    public void setUpChromeDriver() {
        //declare the webdriver and define it from the reusable actions
        driver = ReusableActions.setUpDriver();
    }//end of before class

    @AfterSuite
    public void quitDriverSession() {
        driver.quit();
    }//end of after suite

    //As a search user, I would like to search for four different luxury brand cars
    @Test
    public void searchForMultipleCars() {
        ArrayList<String> carBrands = new ArrayList<>();
        carBrands.add("BMW");
        carBrands.add("Mercedes");
        carBrands.add("Porsche");
        carBrands.add("Tesla");
        for (int i = 0; i < carBrands.size(); i++) {
//go to google page
            driver.navigate().to("https://www.google.com");
            //enter a car in the search field
            ReusableActions.sendKeysAction(driver, "//*[@name='q']", carBrands.get(i), "SearchField");
            //hit submit on the google search button
            ReusableActions.submitAction(driver, "//*[@name='btnK']", "GoogleSubmit");
            String result = ReusableActions.getText(driver, "//*[@id='result-stats']", "SearchResult");
            String[] arrayResult = result.split(" ");
            System.out.println("Result for car brand " + carBrands.get(i) + " " + arrayResult[1]);
        }//end of for loop
    }//end of searchForMultipleCars test case
}//end of class




package Day10_04042023;

import Reusable_Library.ReusableActions;
import org.openqa.selenium.WebDriver;

public class T2_MortgCalc_ReusableActions {
    public static void main(String[] args) {
        //declare the webdriver and define it from the reusable actions
        WebDriver driver = ReusableActions.setUpDriver();
        //go to mortgage calculator homepage
        driver.navigate().to("https://www.mortgagecalculator.org/");
        //enter home value
        ReusableActions.sendKeysAction(driver, "//*[@id  = 'homeval']", "850000", "HomeValue");
        //enter down payment
        ReusableActions.sendKeysAction(driver, "//*[@id  = 'downpayment']", "150000", "DownPayment");
        //click on calculate button
        ReusableActions.clickAction(driver, "//*[@value = 'Calculate']", "CalculateButton");
        //capture the monthly payment
        String monthlyPayment = ReusableActions.getText(driver, "//*[@class= 'left-cell']/h3", "MonthlyPayment");
        //print the monthly payment
        System.out.println("The monthly payment is " + monthlyPayment);
        //quit the driver
        driver.quit();
    }//end of main
}//end of class

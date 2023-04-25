package Day10_04042023;

import Reusable_Library.ReusableActions;
import org.openqa.selenium.WebDriver;

public class T1_MetLife_Reusable {
    public static void main(String[] args) throws InterruptedException {
        //declare the webdriver and define it from the reusable actions
        WebDriver driver = ReusableActions.setUpDriver();
        //navigate to metlife home page
        driver.navigate().to("https://www.metlife.com/");
        //click on solutions tab
        ReusableActions.clickAction(driver, "//*[contains(text(), 'SOLUTIONS')]", "SolutionsTab");
        //click on dental link
        ReusableActions.clickAction(driver, "//*[text() =  'Dental']", "DentalLink");
        Thread.sleep(4000);
        //get the title from dental page
        String dentalPageTitle = ReusableActions.getText(driver, "//*[@class = 'headline__title']", "DentalPageTitle");
        //print the product list
        System.out.println("Dental Page Title Is: " + dentalPageTitle);
    }//end of main
}//end of class

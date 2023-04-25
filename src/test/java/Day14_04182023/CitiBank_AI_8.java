package Day14_04182023;

import Day12_04112023.TestParent;
import Reusable_Library.ReusableActions_Loggers;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;

public class CitiBank_AI_8 extends TestParent {
    @Test
    public void tc001_clickCreditCardLink() throws InterruptedException {
        //navigate to Citi homepage
        driver.navigate().to("https://www.citi.com/");
        //click on 'Credit Cards' tab
        ReusableActions_Loggers.clickAction(driver, "//*[@class= 'main-links plusIcon ng-star-inserted']", logger, "creditCardsTab");
        //wait 2 seconds
        Thread.sleep(2000);
        //click on 'View All Credit Cards' link
        ReusableActions_Loggers.clickAction(driver, "//*[@tabindex= '0']", logger, "viewAllCreditCards");
        //wait 2 seconds
        Thread.sleep(2000);
    }//end of test case
}//end of class

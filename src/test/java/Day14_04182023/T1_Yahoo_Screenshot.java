package Day14_04182023;

import Day12_04112023.TestParent;
import Reusable_Library.ReusableActions_Loggers;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class T1_Yahoo_Screenshot extends TestParent {
    @Test
    public void tc001_verifyStaySignInOptionIsChecked() {
        //navigate to yahoo.com
        driver.navigate().to("https://www.yahoo.com");
        //next we need to click on the sign in button
        ReusableActions_Loggers.clickAction(driver, "//*[text() = 'Sign in']", logger, "SignInButton");
        //verify the stay signed in option is checked
        boolean isStaySignedInChecked = driver.findElement(By.xpath("//*[@id = 'persistent']")).isSelected();
        //the actual validation of our test
        //if the checkbox is checked then we pass the test
        //or else we fail the test
//        ReusableActions_Loggers.isConditionTrue(isStaySignedInChecked,logger);
        if (isStaySignedInChecked == true) {
            logger.log(LogStatus.PASS, "The checkbox is checked: " + isStaySignedInChecked);
        } else {
            logger.log(LogStatus.FAIL, "The checkbox is checked: " + isStaySignedInChecked);
        }
    }//end of test case 1

    @Test
    public void tc002_verifySignInOptionIsUnchecked() {
        //click on the checkbox to uncheck it
        ReusableActions_Loggers.clickAction(driver, "//*[@class = 'stay-signed-in checkbox-containerxyz']", logger, "CheckBox");
        //check the state of the checkbox (it should be unchecked now)
        boolean isStaySignedInChecked = driver.findElement(By.xpath("//*[@id = 'persistent']")).isSelected();
        //the actual validation of our test
        //if the checkbox is checked then we pass the test
        //or else we fail the test
//        ReusableActions_Loggers.isConditionTrue(isStaySignedInChecked,logger);
        if (isStaySignedInChecked == true) {
            logger.log(LogStatus.PASS, "The checkbox is checked: " + isStaySignedInChecked);
        } else {
            logger.log(LogStatus.FAIL, "The checkbox is checked: " + isStaySignedInChecked);
        }
    }//end of test case 2
    //making a change
}//end of class

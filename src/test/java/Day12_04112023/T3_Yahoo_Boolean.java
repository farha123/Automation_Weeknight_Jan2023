package Day12_04112023;

import Reusable_Library.ReusableActions;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class T3_Yahoo_Boolean extends TestParent {
    @Test
    public void tc001_verifyStaySignInOptionIsChecked() {
        //navigate to yahoo.com
        driver.navigate().to("https://www.yahoo.com");
        //next we need to click on the sign in button
        ReusableActions.clickAction(driver, "//*[text() = 'Sign in']", "SignInButton");
        //verify the stay signed in option is checked
        boolean isStaySignedInChecked = driver.findElement(By.xpath("//*[@id = 'persistent']")).isSelected();
        //print true if checkbox is selected
        System.out.println("The checkbox is checked " + isStaySignedInChecked);
    }//end of test case 1

    @Test
    public void tc002_verifySignInOptionIsUnchecked() {
        //click on the checkbox to uncheck it
        ReusableActions.clickAction(driver, "//*[@class = 'stay-signed-in checkbox-container']", "CheckBox");
        //check the state of the checkbox (it should be unchecked now)
        boolean isStaySignedInChecked = driver.findElement(By.xpath("//*[@id = 'persistent']")).isSelected();
        //print false if checkbox is not checked
        System.out.println("The checkbox is checked: " + isStaySignedInChecked);
    }//end of test case 2
}//end of yahoo test class

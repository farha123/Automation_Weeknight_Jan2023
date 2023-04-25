package Day12_04112023;

import Reusable_Library.ReusableActions;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class FidelisCare_AI_7 extends TestParent {

    @Test(priority = 1)
    public void getDentalCoverage() {
        //navigate to Fidelis Care Homepage
        driver.navigate().to("https://www.fideliscare.org/");
        //click on search element
        ReusableActions.clickAction(driver, "//*[@class = 'tool dropdown search']", "searchElement");
        //enter 'Get dental coverage' into search field
        ReusableActions.sendKeysAction(driver, "//*[@class = 'form-control search-input']", "Get dental coverage", "getDentalCoverage");
        //click on search icon
        ReusableActions.clickAction(driver, "//*[@class = 'input-group-btn']", "searchIcon");
        //capture search result by splitting and only printing search number
        String result = ReusableActions.getText(driver, "//*[@class = 'gsc-result-info']", "searchResult");
        String[] arrayResult = result.split(" ");
        System.out.println("Result is " + arrayResult[1]);
        //click on 'Get Dental Coverage' link
        ReusableActions.clickAction(driver, "//*[text() = 'Get Dental Coverage']", "getDentalCoverageLink");
    }//end of test case 1

    @Test(dependsOnMethods = "getDentalCoverage")
    public void contactMe() {
        //switch to 'Contact Me' new tab
        ReusableActions.switchToTabByIndex(driver, (1));
        //enter first name
        ReusableActions.sendKeysAction(driver, "//*[@id = 'firstName']", "Farha", "firstName");
        //enter last name
        ReusableActions.sendKeysAction(driver, "//*[@id = 'lastName']", "Hussain", "lastName");
        //enter zipcode
        ReusableActions.sendKeysAction(driver, "//*[@id = 'zipCode']", "11218", "zipCode");
        //select county
        ReusableActions.dropdownOptions(driver, "//*[@id = 'county']", "New York");
        //enter phone number
        ReusableActions.sendKeysAction(driver, "//*[@id = 'phoneNumber']", "7194564567", "phoneNumber");
        //enter e-mail
        ReusableActions.sendKeysAction(driver, "//*[@id = 'email']", "fhussain55@yahoo.com", "eMail");
        //click on 'Contact Me' checkbox
        ReusableActions.clickAction(driver, "//*[@for= 'contactMe']", "checkBox");
        //click on 'Contact Me' button
        ReusableActions.clickAction(driver, "//*[@type= 'submit']", "contactMeButton");
        //capture submission message
        String result = ReusableActions.getText(driver, "//*[@role= 'alert']", "submissionMessage");
        System.out.println(result);
        System.out.println();
    }//end of test case 2

    @Test(priority = 3)
    public void memberOnlinePortal() {
        //switch back to default tab
        ReusableActions.switchToTabByIndex(driver, (0));
        //click on login
        ReusableActions.clickAction(driver, "//*[@class = 'dropdown-toggle']", "loginButton");
        //click on 'Member online portal' link
        ReusableActions.clickAction(driver, "//*[@target ='_blank']", "memberOnlinePortal");
        //switch to new member portal tab
        ReusableActions.switchToTabByIndex(driver, (2));
        //capture and print out helpful hints
        String result = ReusableActions.getText(driver, "//*[@class= 'tipsContentText']", "helpfulHints");
        System.out.println(result);
        driver.close();
    }//end of test case 3

}//end of test class

package Day8_03282023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;

public class Hotels_AI {
    public static void main(String[] args) throws InterruptedException {
        //define the webdriver manager setup for chromedriver
        WebDriverManager.chromedriver().setup();
        //initialize chrome option
        ChromeOptions options = new ChromeOptions();
        // add the options for maximizing the chrome meeting
        options.addArguments("start-maximized");
        //define the chrome driver to use for your test
        //creating an instance for a chrome driver(browser) to use for automation
        WebDriver driver = new ChromeDriver(options);
        //create array list for destinations
        ArrayList<String> destinations = new ArrayList<>();
        destinations.add("Ohio");//index 0 or i = 0
        destinations.add("Florida");//index 1 or i = 1
        destinations.add("Nevada");//index 2 or i = 2

        for (int i = 0; i < destinations.size(); i++) {
            //go to hotels.com
            driver.navigate().to("https://www.hotels.com");
            //wait a bit
            Thread.sleep(2000);

            //click on the going to search bar
            try {
                driver.findElement(By.xpath("//*[@aria-label='Going to']")).click();
                Thread.sleep(2000);
            } catch (Exception e) {
                System.out.println("Unable to click on Going to " + e);
            }//end of going to search try catch block

            //type in a destination
            try {
                driver.findElement(By.xpath("//*[@id='destination_form_field']")).sendKeys(destinations.get(i));
                Thread.sleep(2000);
                //select the first suggestion from the dropdown
                driver.findElements(By.xpath("//*[@data-stid='destination_form_field-result-item-button']")).get(0).click();
            } catch (Exception e) {
                System.out.println("Unable to enter text in search field " + e);
            }//end of search field try catch block

            //click on the search button
            try {
                driver.findElement(By.xpath("//*[@id = 'search_button']")).click();
            } catch (Exception e) {
                System.out.println("Unable to click on search button " + e);
            }

            Thread.sleep(3000);

            //click on the first hotel link
            try {
                ArrayList<WebElement> hotelLinks = new ArrayList<>(driver.findElements(By.xpath("//*[@data-stid = 'open-hotel-information']")));
                if (i == 0) {
                    hotelLinks.get(0).click();
                } else if (i == 1) {
                    hotelLinks.get(2).click();
                } else if (i == 2) {
                    hotelLinks.get(1).click();
                }
            } catch (Exception e) {
                System.out.println("Unable to click on first hotel link " + e);
            }
// capture all tabs
            ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
            // switch to new tabs
            driver.switchTo().window(tabs.get(1));
            //wait 3 seconds
            Thread.sleep(3000);

            //capture the name of the hotel
            try {
                String hotelName = driver.findElement(By.xpath("//*[@class = 'uitk-heading uitk-heading-3']")).getText();
                System.out.println("The hotel name is " + hotelName);
            } catch (Exception e) {
                System.out.println("Unable to print the hotel name " + e);
            }

            //wait 3 seconds
            Thread.sleep(2000);

            try {
                String price = driver.findElements(By.xpath("//*[@class = 'uitk-text uitk-type-600 uitk-type-bold uitk-text-emphasis-theme']")).get(0).getText();
                System.out.println("The hotel price is " + price);
            } catch (Exception e) {
                System.out.println("Unable to print the hotel price " + e);
            }

            //click on reserve button
            try {
                driver.findElements(By.xpath("//*[@data-stid= 'submit-hotel-reserve']")).get(0).click();
            } catch (Exception e) {
                System.out.println("Unable to click reserve buton.." + e);
            }

            //click on pay now (test should continue even if pop up - pay now does not appear)
            try {
                driver.findElement(By.xpath("//span[text() = 'Pay now']")).click();
            } catch (Exception e) {
                System.out.println("Unable to click on pay now button.." + e);
            }

            Thread.sleep(3000);
            //capture amenities
            try {
                String amenities = driver.findElement(By.xpath("//*[@class = 'c-hds-success-1']")).getText();
                //print out dates
                System.out.println(amenities);
            } catch (Exception e) {
                System.out.println("Unable to capture and print out amenities.." + e);
            }//end of capture amenities
            //close tab
            driver.close();
            //switch back to the parent tab
            driver.switchTo().window(tabs.get(0));
        }//end of for loop
        //quit driver
        driver.quit();
    }//end of main
}//end of class

package Day8_03282023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;

public class WeightWatchers_AI {
    public static void main(String[] args) throws InterruptedException {
        //set up chromedriver as web driver manager
        WebDriverManager.chromedriver().setup();
        //declare Chrome options
        ChromeOptions options = new ChromeOptions();
        //start Chrome maximized
        options.addArguments("--kiosk");
        //start Chrome incognito
        options.addArguments("incognito");
        //define the webdriver and pass the options
        WebDriver driver = new ChromeDriver(options);

        //set up array list for zipcodes
        ArrayList<String> zipcodes = new ArrayList<>();
        zipcodes.add("11218");//index 0
        zipcodes.add("11219");//index 1
        zipcodes.add("11228");//index 2

        //use a for loop to print out zipcodes
        for (int i = 0; i < zipcodes.size(); i++) {
            //go to Weight Watchers website
            driver.navigate().to("https://www.weightwatchers.com/us/");

            //click on Find a Workshop
            try {
                driver.findElement(By.xpath("//*[@class='MenuItem_menuItemIconWrapper__ZwyL0']")).click();
            } catch (Exception e) {
                System.out.println("Unable to click Find a Workshop " + e);
            }//end of clicking Find a Workshop catch block
            //wait 3 seconds
            Thread.sleep(3000);

            //click on In-Person link
            try {
                driver.findElement(By.xpath("//*[@class='buttonText-3DCCO']")).click();
            } catch (Exception e) {
                System.out.println("Unable to click In-Person link " + e);
            }//end of clicking In-Person link catch block
            //wait 3 seconds
            Thread.sleep(3000);

            //enter a zipcode
            try {
                driver.findElement(By.xpath("//*[@id='location-search']")).sendKeys(zipcodes.get(i));
            } catch (Exception e) {
                System.out.println("Unable to enter zipcode " + e);
            }//end of entering zipcode catch block
            //wait 3 seconds
            Thread.sleep(3000);

            //click submit on search arrow
            try {
                driver.findElement(By.xpath("//*[@href='/us/find-a-workshop/svg-symbols.svg#primary-link']")).click();
            } catch (Exception e) {
                System.out.println("Unable to click submit on search arrow" + e);
            }//end of clicking submit on search arrow catch block
            //wait 3 seconds
            Thread.sleep(3000);

            //click on studio link
            try {
                ArrayList<WebElement> studioLinks = new ArrayList<>(driver.findElements(By.xpath("//*[@class='linkUnderline-1_h4g']")));
                if (i == 0) {
                    studioLinks.get(1).click();
                } else if (i == 1) {
                    studioLinks.get(2).click();
                } else if (i == 2) {
                    studioLinks.get(0).click();
                }
            } catch (Exception e) {
                System.out.println("Unable to click on studio link " + e);
            }//end of click on studio link catch block

            //wait three seconds
            Thread.sleep(3000);

//capture address
            try {
                String address = driver.findElement(By.xpath("//*[@class='address-2PZwW']")).getText();
                //print out address
                String[] arrayResult = address.split("In-Person");
                System.out.println("Address is " + arrayResult[0]);
            } catch (Exception e) {
            }//end of capture address catch block

            //define javascript executor
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            //scroll down to Upcoming In-Person Workshops schedule
            jse.executeScript("scroll(0,800)");
//wait 3 seconds
            Thread.sleep(3000);
            //capture table
            try {
                String table = driver.findElement(By.xpath("//*[@class='workshopSchedule-2foP8']")).getText();
                System.out.println(table);
            } catch (Exception e) {
                System.out.println("Unable to capture table" + e);
            }//end of capture table catch block
        }//end of for loop
        driver.quit();
    }//end of main
}//end of class

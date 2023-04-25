package Day6_03212023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;

public class Action_Item_3 {
    public static void main(String[] args) throws InterruptedException {
//set up chromedriver with webdrivermanager
        WebDriverManager.chromedriver().setup();
        //declare chrome options
        ChromeOptions options = new ChromeOptions();
        //start maximized for Mac
        options.addArguments("start-maximized");
        options.addArguments("--kiosk");
        //define the webdriver and pass the options
        WebDriver driver = new ChromeDriver(options);

        //set up array list for sports
        ArrayList<String> sports = new ArrayList<>();
        sports.add(" soccer ");
        sports.add(" hockey ");
        sports.add(" football ");
        sports.add(" tennis ");

        for (int i = 0; i < sports.size(); i++) {
            //go to yahoo home page
            driver.navigate().to("https://www.yahoo.com/");
            //wait a few seconds
            Thread.sleep(3000);
            //enter a sports keyword into the search field
            driver.findElement(By.xpath("//*[@name='p']")).sendKeys(sports.get(i));
            //hit submit on the yahoo search button
            driver.findElement(By.xpath("//*[@id='ybar-search']")).submit();
            //wait a few seconds
            Thread.sleep(3000);
            //capture the search results
            String results = driver.findElement(By.xpath("//*[@class=' fz-14 lh-22']")).getText();
            //extract search number from the entire text
            String[] arrayResult = results.split(" ");
            System.out.println("For" + sports.get(i) + " the search number is " + arrayResult[1]);
//define javascript executor
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            //scroll to the bottom of the page
            jse.executeScript("scroll(0,3000)");
//click on About this page link
            driver.findElement(By.xpath("//*[text() = 'About this page']")).click();
            Thread.sleep(2000);
            //capture text
            String searchResult = driver.findElement(By.xpath("//*[@id='announcementdiv']")).getText();
            //print result
            System.out.println("" + searchResult);
            //click on the Narrow your search article
            driver.findElement(By.xpath("//*[text() = 'Narrow your search with Yahoo Advance Web Search']")).click();
            //wait a few seconds
            Thread.sleep(2000);
            //capture the message
            String result = driver.findElement(By.xpath("//*[@id='article_container']")).getText();
            System.out.println("" + result);
        }//end of loop
        driver.quit();
    }//end of main
}//end of class


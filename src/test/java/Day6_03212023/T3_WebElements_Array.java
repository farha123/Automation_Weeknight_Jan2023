package Day6_03212023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;

public class T3_WebElements_Array {
    public static void main(String[] args) throws InterruptedException {
        //set up your chromedriver with webdrivermanager
        WebDriverManager.chromedriver().setup();
        //declare chrome options
        ChromeOptions options = new ChromeOptions();
        //start maximized for windows
        options.addArguments("start-maximized");
        //define the webdriver and pass the options
        WebDriver driver = new ChromeDriver(options);
        //go to yahoo home page
        driver.navigate().to("https://www.yahoo.com/");
        //wait a few seconds
        Thread.sleep(2000);
        //store all the header links into an arraylist of type WebElement
        ArrayList<WebElement> headerLinks = new ArrayList<>(driver.findElements(By.xpath("//*[contains(@class, '_yb_pw')]")));
        //click on sports link from yahoo.com
        headerLinks.get(3).click();
        //wait a few seconds
        Thread.sleep(2000);
        //go to yahoo home page
        driver.navigate().to("https://www.yahoo.com/");
        headerLinks = new ArrayList<>(driver.findElements(By.xpath("//*[contains(@class, '_yb_pw')]")));
        //wait a few seconds
        Thread.sleep(2000);
        //click on finance
        headerLinks.get(2).click();
        //wait a few seconds
        Thread.sleep(2000);
        //quit the browser
        driver.quit();
    }//end of main
}//end of class

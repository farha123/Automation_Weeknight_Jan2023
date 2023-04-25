package Day6_03212023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class T4_Scroll {
    public static void main(String[] args) throws InterruptedException {
        //set up your chromedriver with webdrivermanager
        WebDriverManager.chromedriver().setup();
        //declare chrome options
        ChromeOptions options = new ChromeOptions();
        //start maximized for windows
        options.addArguments("start-maximized");
        //define the webdriver and pass the options
        WebDriver driver = new ChromeDriver(options);
        //go to google home page
        driver.navigate().to("https://www.mlcalc.com/");
        //wait a few seconds
        Thread.sleep(2000);
        //define javascript executor (library that allows us to scroll)
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        //scroll down 800 pixels (based on your need adjust it by + or - 200)
        jse.executeScript("scroll(0,800)");
        //wait a few seconds
        Thread.sleep(2000);
        //scroll up 400 pixels
        jse.executeScript("scroll(0,-400)");
        //wait a few seconds
        Thread.sleep(2000);
        //scroll to the calculate button
        //first declare the calculate button into a WebElement variable
        WebElement calcButton = driver.findElement(By.xpath("//*[@value = 'Calculate']"));
        //scroll to the calculate button
        jse.executeScript("arguments[0].scrollIntoView(true);", calcButton);
        //wait a few seconds
        Thread.sleep(4000);
        //quit driver
        driver.quit();
    }//end of main
}//end of class

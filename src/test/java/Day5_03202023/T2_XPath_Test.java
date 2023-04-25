package Day5_03202023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class T2_XPath_Test {
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
        driver.navigate().to("https://www.yahoo.com/");
        //wait a few seconds
        Thread.sleep(2000);
        //click on sign in button
        driver.findElement(By.xpath("//*[text() = 'Sign in']")).click();
        //wait a few seconds
        Thread.sleep(2000);
        //go back to yahoo.com
        driver.navigate().back();
        //wait a few seconds
        Thread.sleep(2000);
        //click on the bell icon (notification icon)
        driver.findElement(By.xpath("//*[contains(@class, 'rapid-nonanchor')]")).click();
        //wait a few seconds
        Thread.sleep(2000);
        //quit the chrome driver
        driver.quit();
    }//end of main
}//end of class

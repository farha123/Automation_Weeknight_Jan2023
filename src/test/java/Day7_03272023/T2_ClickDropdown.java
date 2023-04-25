package Day7_03272023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class T2_ClickDropdown {
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
        driver.navigate().to("https://www.mortgagecalculator.org/");
        //wait a few seconds
        Thread.sleep(2000);
        //store the dropdown into a webelement variable
        WebElement startMonth = driver.findElement(By.xpath("//*[@name = 'param[start_month]']"));
        //scroll to the month dropdown (for better visibility)
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView(true);", startMonth);
        //click on the dropdown (this will expand the dropdown)
        startMonth.click();
        //click on Jun using a regular xpath with text
        driver.findElement(By.xpath("//*[text() = 'Jun']")).click();
        //wait a few seconds
        Thread.sleep(4000);
        //quit browser
        driver.quit();
    }//end of main
}//end of class

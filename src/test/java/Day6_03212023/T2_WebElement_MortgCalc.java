package Day6_03212023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class T2_WebElement_MortgCalc {
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
        //type 750000 into the home value field
        //we declare a webelement variable called homeVal
        //then store the xpath and find element statement into that variable
        WebElement homeValue = driver.findElement(By.xpath("//*[@id= 'homeval']"));
        //clear the field (so that new value could be typed in)
        homeValue.clear();
        //enter the new value (950000)
        homeValue.sendKeys("950000");
        //wait a few seconds
        Thread.sleep(3000);
        //quit the driver
        driver.quit();
    }//end of main
}//end of class

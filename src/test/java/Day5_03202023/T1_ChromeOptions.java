package Day5_03202023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class T1_ChromeOptions {
    public static void main(String[] args) throws InterruptedException {
//set up your chromedriver with webdrivermanager
        WebDriverManager.chromedriver().setup();
        //declare chrome options
        ChromeOptions options = new ChromeOptions();
        //start maximized for windows
        options.addArguments("start-maximized");
     //    options.addArguments("incognito");
//       options.addArguments("headless");
        //for mac users use the below line of code
//        options.addArguments("start-fullscreen");
        //or you can use below
        options.addArguments("--kiosk");
        //define the webdriver and pass the options
        WebDriver driver = new ChromeDriver(options);
        //go to google home page
        driver.navigate().to("https://www.google.com");
        //wait a few seconds
        Thread.sleep(2000);
        //type cars into google search field (relative xpath)
        driver.findElement(By.xpath("//*[@name = 'q']")).sendKeys("cars");
        //this is an example of an absolute xpath
//        driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input")).sendKeys("cars");
        //submit on google search button
        driver.findElement(By.xpath("//*[@name = 'btnK']")).submit();
        //capture the search result and print it
        String searchResult = driver.findElement(By.xpath("//*[@id= 'result-stats']")).getText();
        System.out.println("Result search text is " + searchResult);
        //quit the chrome driver
        driver.quit();
    }//end of main
}//end of class

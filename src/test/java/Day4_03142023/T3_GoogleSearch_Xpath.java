package Day4_03142023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class T3_GoogleSearch_Xpath {
    public static void main(String[] args) throws InterruptedException {
//set your web driver manager to indicate what type of browser/driver you are using
        WebDriverManager.chromedriver().setup();

//define the Web Driver/Browser you want to use for your test
        WebDriver driver = new ChromeDriver();

//navigate to Google Home Page
        driver.navigate().to("https://www.google.com");

//wait few seconds
        Thread.sleep(2000);


//enter the keyword BMW to the search field
        driver.findElement(By.xpath("//*[@name='q']")).sendKeys("BMW");

//hit submit on the google search button
        driver.findElement(By.xpath("//*[@name='btnK']")).submit();

        //wait few seconds for page to load
        Thread.sleep(2000);

//capture the search results
        String results = driver.findElement(By.xpath("//*[@id='result-stats']")).getText();
//System.out.println("Result is " + results);
//using split function we can extract out the search number from the entire text
        String[] arrayResult = results.split(" ");
        System.out.println("Search number is " + arrayResult[1]);

        //finally quit your browser to clear session
        driver.quit();

    }//end of main
}//end of class

package Day7_03272023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;

public class T3_SwitchTabs {
    public static void main(String[] args) throws InterruptedException {
        //setup your chromedriver with webdrivermanager
        WebDriverManager.chromedriver().setup();
        //declare chrome options
        ChromeOptions options = new ChromeOptions();
        //start maximized for windows
        options.addArguments("start-maximized");
        //define the webdriver
        WebDriver driver = new ChromeDriver(options);
        //go to yahoo home page
        driver.navigate().to("https://www.fideliscare.org/");
        //wait two seconds
        Thread.sleep(2000);
        //click on shop for a plan
        driver.findElement(By.xpath("//*[text() = 'Shop For a Plan']")).click();
        //wait 2 secs
        Thread.sleep(2000);
        //click on medicaid managed care
        driver.findElement(By.xpath("//*[text() = 'Medicaid Managed Care']")).click();
        //wait 2 secs
        Thread.sleep(2000);
        //click on find a doctor (will launch a new tab)
        driver.findElement(By.xpath("//*[@class= 'btn btn-outline-primary btn-external btn-show link-external']")).click();
        //wait 2 secs
        Thread.sleep(2000);
        //store the tabs into an arraylist
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        //switch to the new tab
        driver.switchTo().window(tabs.get(1));
        //enter a zipcode into the search field
        driver.findElement(By.xpath("//*[@id = 'searchLocation']")).sendKeys("11230");
        //wait 2 secs
        Thread.sleep(2000);
        //close the new tab
        driver.close();
        //wait 2 secs
        Thread.sleep(2000);
        //switch back to the parent tab
        driver.switchTo().window(tabs.get(0));
        //after switching back to the parent tab, click on the login button
        driver.findElement(By.xpath("//*[@class = 'tool dropdown login']")).click();
        //wait 2 secs
        Thread.sleep(2000);
        //quit the driver
        driver.quit();
    }//end of main
}//end of class

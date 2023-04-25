package Day9_04032023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class T2_ImplicitWait {
    public static void main(String[] args) {
//set up your chromedriver with WebDriverManager
        WebDriverManager.chromedriver().setup();
//declare chrome options
        ChromeOptions options = new ChromeOptions();
//start maximized for windows
        options.addArguments("start-maximized");
//define the WebDriver
        WebDriver driver = new ChromeDriver(options);
//go to mortgage calculator homepage
        driver.navigate().to("https://www.usps.com");
//implicitly wait for 5 seconds, global wait and it applies to all the elements (should be declared before all elements)
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

//hover over send tab
//store the send tab element into a WebElement variable
        WebElement sendTab = driver.findElement(By.xpath("//*[@id='mail-ship-width']"));
//declare mouse actions
        Actions mouseActions = new Actions(driver);
//move to desired element (send tab)
        mouseActions.moveToElement(sendTab).perform();

//define a calculate a price button
        WebElement calcPrice = driver.findElement(By.xpath("//*[@class= 'tool-calc']"));
//move to calculate a price button and click on it
        mouseActions.moveToElement(calcPrice).click().perform();

//define usps home variable
        WebElement uspsHome = driver.findElement(By.xpath("//*[@class = 'logo-usps']"));
//right click (contextClick()) on usps home logo
        mouseActions.moveToElement(uspsHome).contextClick().perform();

//double-click on the usps home logo
        mouseActions.moveToElement(uspsHome).doubleClick().perform();

//quit the driver
        driver.quit();

    }//end of main
}//end of class
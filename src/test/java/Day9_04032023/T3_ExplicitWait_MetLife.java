package Day9_04032023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class T3_ExplicitWait_MetLife {
    public static void main(String[] args) {
        //setup your chromedriver with webdrivermanager
        WebDriverManager.chromedriver().setup();
        //declare chrome options
        ChromeOptions options = new ChromeOptions();
        //start maximized for windows
        options.addArguments("start-maximized");
        //define the webdriver
        WebDriver driver = new ChromeDriver(options);
        //navigate to metlife home page
        driver.navigate().to("https://www.metlife.com/");
        //declare the explicit wait
        WebDriverWait wait = new WebDriverWait(driver, 10);
        //click on solutions tab
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[contains(text(), 'SOLUTIONS')]"))).get(0).click();
        //click on the dental link
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text() =  'Dental']"))).click();
        //quit the driver
        driver.quit();
    }//end of main
}//end of class

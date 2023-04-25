package Day8_03282023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class T1_TryCatch_MortCalc {
    public static void main(String[] args) throws InterruptedException {
        //setup your chromedriver with webdrivermanager
        WebDriverManager.chromedriver().setup();
        //declare chrome options
        ChromeOptions options = new ChromeOptions();
        //start maximized for windows
        options.addArguments("start-maximized");
        //define the webdriver
        WebDriver driver = new ChromeDriver(options);
        //go to mortgage calculator homepage
        driver.navigate().to("https://www.mortgagecalculator.org/");
        //wait two seconds
        Thread.sleep(2000);

        try {
            //we store homevalue as webelement
            WebElement homeValue = driver.findElement(By.xpath("//*[@id  = 'homeval']"));
            //clear the field
            homeValue.clear();
            //enter 850000
            homeValue.sendKeys("850000");
        } catch (Exception e) {
            System.out.println("Unable to enter home value because of error: " + e);
        }//end of home value try catch

        try{
            //enter down payment
            WebElement downPayment = driver.findElement(By.xpath("//*[@id  = 'downpayment']"));
            //clear the field
            downPayment.clear();
            //enter 150000 as downpayment
            downPayment.sendKeys("150000");
        } catch (Exception e){
            System.out.println("Unable to enter down payment value because of error: " + e);
        }//end of down payment try catch

        try {
            //click on calculate button
            driver.findElement(By.xpath("//*[@value = 'Calculate']")).click();
        }catch (Exception e){
            System.out.println("Unable to click on calculate button because of error: " + e);
        }//end of calculate try catch

        try {
            //capture the monthly payment
            String monthlyPayment = driver.findElements(By.xpath("//*[@class= 'left-cell']/h3")).get(0).getText();
            System.out.println("The Monthly Payment is: " + monthlyPayment);
        }catch (Exception e){
            System.out.println("Unable to capture the monthly payment because of error: " + e);
        }//end of monthly payment try catch

        //Quit the Driver
        driver.quit();
    }//end of main
}//end of class

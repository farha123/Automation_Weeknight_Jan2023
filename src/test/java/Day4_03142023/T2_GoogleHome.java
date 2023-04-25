package Day4_03142023;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class T2_GoogleHome {
    public static void main(String[] args) throws InterruptedException {
        //set your web driver manager to indicate what type of browser/driver you are using
        WebDriverManager.chromedriver().setup();

        //define the Web Driver/Browser you want to use for your test
        WebDriver driver = new ChromeDriver();

        //navigate to Google Home Page
        driver.navigate().to("https://www.google.com/");

        //wait few seconds
        Thread.sleep(2000);

        //quit the driver
        driver.quit();

     }//end of main
}//end of class

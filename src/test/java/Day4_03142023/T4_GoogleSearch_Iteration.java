package Day4_03142023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

public class T4_GoogleSearch_Iteration {
    public static void main(String[] args) throws InterruptedException {
//set your web driver manager to indicate what type of browser/driver you are using
        WebDriverManager.chromedriver().setup();

//define the Web Driver/Browser you want to use for your test
        WebDriver driver = new ChromeDriver();

//set up array list for cars
        ArrayList<String> cars = new ArrayList<>();
        cars.add("BMW");
        cars.add("Lexus");
        cars.add("Mercedes");

        for(int i =0; i<cars.size(); i++) {
            //navigate to Google Home Page
            driver.navigate().to("https://www.google.com");

            //wait few seconds
            Thread.sleep(2000);

            //enter the keyword BMW to the search field
            driver.findElement(By.xpath("//*[@name='q']")).sendKeys(cars.get(i));

            //hit submit on the Google search button
            driver.findElement(By.xpath("//*[@name='btnK']")).submit();

            //wait few seconds for page to load
            Thread.sleep(2000);

            //capture the search results
            String results = driver.findElement(By.xpath("//*[@id='result-stats']")).getText();
            //System.out.println("Result is " + results);
            //using split function we can extract out the search number from the entire text
            String[] arrayResult = results.split(" ");
            System.out.println("For " + cars.get(i) + " the search number is " + arrayResult[1]);
        }//end of loop

//finally, quit your browser to exit the driver
        driver.quit();
    }//end of main
}//end of class

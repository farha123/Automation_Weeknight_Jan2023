package Day4_03142023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

public class Action_Item_2_Question_2 {
    public static void main(String[] args) throws InterruptedException {
        //set your web driver manager to indicate what type of driver you are using
        WebDriverManager.chromedriver().setup();

        //define the Web Driver you want to use for your test
        WebDriver driver = new ChromeDriver();

        //set up array list for sports
        ArrayList<String> sports = new ArrayList<>();
        sports.add(" soccer ");
        sports.add(" hockey ");
        sports.add(" football ");
        sports.add(" tennis ");

        for (int i = 0; i<sports.size(); i++) {
            //navigate to Bing homepage
            driver.navigate().to(" https://www.bing.com/ ");

            //wait two seconds
            Thread.sleep(2000);
            //enter a sports keyword into the search field
            driver.findElement(By.xpath("//*[@name='q']")).sendKeys(sports.get(i));

            //hit submit on the Bing search button
            driver.findElement(By.xpath(" //*[@id='sb_form_q']")).submit();

            //wait two seconds
            Thread.sleep(2000);

            //capture the search results
            String results = driver.findElement(By.xpath("//*[@class='sb_count']")).getText();
            //System.out.prinln ("Result is + results);
            //using the split function we can extract the search number from the entire text
            String[] arrayResult = results.split(" ");
            System.out.println("For " + sports.get(i) + " the search number is " + arrayResult[1]);
        }//end of loop

        //quit  your browser to exit the driver
        driver.quit();
    }//end of main
}//end of class

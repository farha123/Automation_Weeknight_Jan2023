package Reusable_Library;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.util.ArrayList;

public class ReusableActions_Loggers {
    public static WebDriver setUpDriver() {
        //setup your chromedriver with webdrivermanager
        WebDriverManager.chromedriver().setup();
        //declare chrome options
        ChromeOptions options = new ChromeOptions();
        //start maximized for windows
        options.addArguments("start-maximized");
        //define the webdriver
        WebDriver driver = new ChromeDriver(options);
        return driver;
    }//end of web driver method

    public static void clickAction(WebDriver driver, String xpath, ExtentTest logger, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            element.click();
            logger.log(LogStatus.PASS, "Successfully clicked on " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to click on element: " + elementName + " reason: " + e);
            logger.log(LogStatus.FAIL, "Unable to click on " + elementName);
            getScreenShot(driver, elementName, logger);
        }
    }//end of click action

    public static String getText(WebDriver driver, String xpath, ExtentTest logger, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        String returnText = "";
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            returnText = element.getText();
            logger.log(LogStatus.PASS, "Successfully got text " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to capture text: " + elementName + " reason: " + e);
            logger.log(LogStatus.FAIL, "Unable to get text " + elementName);
            getScreenShot(driver, elementName, logger);
        }
        return returnText;
    }//end of getText method

    public static void sendKeysAction(WebDriver driver, String xpath, String userInput, ExtentTest logger, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            element.clear();
            element.sendKeys(userInput);
            logger.log(LogStatus.PASS, "Successfully sent keys " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to send keys to: " + elementName + " for reason: " + e);
            logger.log(LogStatus.FAIL, "Unable to send keys " + elementName);
            getScreenShot(driver, elementName, logger); 
        }
    }//end of send keys action

    public static void dropdownOptions(WebDriver driver, String xpath, ExtentTest logger, String optionToSelect) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            WebElement dropdown = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            Select dropdownMenu = new Select(dropdown);
            dropdownMenu.selectByVisibleText(optionToSelect);
            logger.log(LogStatus.PASS, "Successfully selected dropdown option ");
        } catch (Exception e) {
            System.out.println("Unable to select dropdown option: " + optionToSelect + " for reason " + e);
            logger.log(LogStatus.FAIL, "Unable to select dropdown option ");
            getScreenShot(driver, optionToSelect, logger);
        }
    }//end of dropdown options

    public static void scrollByPixels(WebDriver driver, ExtentTest logger, int pixels) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript(("scroll(0, " + pixels + ")"));
        logger.log(LogStatus.PASS, "Successfully scrolled ");
    }//end of scrollByPixels

    public static void mouseHover(WebDriver driver, String xpath, ExtentTest logger, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
        Actions mouseActions = new Actions(driver);
        mouseActions.moveToElement(element).perform();
        logger.log(LogStatus.PASS, "Successfully hovered over ");
    }//end of mouseHover

    public static void submitAction(WebDriver driver, String xpath, ExtentTest logger, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            element.submit();
            logger.log(LogStatus.PASS, "Successfully submit " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to submit on element: " + elementName + " for reason: " + e);
            logger.log(LogStatus.FAIL, "Unable to submit " + elementName);
            getScreenShot(driver, elementName, logger);
        }
    }//end of submit action

    public static void switchToTabByIndex(WebDriver driver, ExtentTest logger, int index) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(index));
        logger.log(LogStatus.PASS, "Successfully switched tabs ");
    }//end of switching tabs by index

    public static void getScreenShot(WebDriver driver, String imageName, ExtentTest logger) {
        try {
            String fileName = imageName + ".png";
            String directory = null;
            String snPath = null;
            directory = "src/main/java/HTML_Report/Screenshots/";
            snPath = "Screenshots//";
            File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(sourceFile, new File(directory + fileName));
            //String imgPath = directory + fileName;
            String image = logger.addScreenCapture(snPath + fileName);
            logger.log(LogStatus.FAIL, "", image);
        } catch (Exception e) {
            logger.log(LogStatus.FAIL, "Error Occurred while taking SCREENSHOT!!!");
            e.printStackTrace();
        }
    }//end of getScreenshot method
}



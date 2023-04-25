package Day10_04042023;

import Reusable_Library.ReusableActions;
import org.openqa.selenium.WebDriver;

public class BestBuy_AI {
    public static void main(String[] args) throws InterruptedException {
        //define the webdriver and declare it from reusable actions
        WebDriver driver = ReusableActions.setUpDriver();

        //navigate to Best Buy homepage
        driver.navigate().to("https://www.bestbuy.com/");

        //enter keyword Macbook on the search field
        ReusableActions.sendKeysAction(driver, "//*[@id = 'gh-search-input']", "Macbook", "SearchField");

        //click on search icon
        ReusableActions.clickAction(driver, "//*[@class = 'header-search-icon']", "SearchIcon");

        //sort by best selling
        ReusableActions.dropdownOptions(driver, "//*[@id = 'sort-by-select']", "Best Selling");

        //click on first Macbook link
        ReusableActions.clickAction(driver, "//*[contains(@href, '/site/macbook-air-13-6-laptop')]", "macbookLink");

        //scroll to 'add to cart' button using pixels
        ReusableActions.scrollByPixels(driver, (2100));

        //click 'add to cart' button
        ReusableActions.clickAction(driver, "//*[@class = 'fulfillment-add-to-cart-button']", "addToCart");
        Thread.sleep(5000);

        //capture amount in cart pop-up
        String total = ReusableActions.getText(driver, "//*[@class = 'shop-cart-subtotal']", "cartAmount");
        System.out.println(total);
        Thread.sleep(5000);

        //hover over 'continue shopping' button
        ReusableActions.mouseHover(driver, "//*[@class='c-button-link continue-shopping']", "continueShopping");
        Thread.sleep(5000);

//click on 'continue shopping' button
        ReusableActions.clickAction(driver, "//*[@class='c-button-link continue-shopping']", "continueShopping");
        Thread.sleep(5000);

        //quit driver
        driver.quit();

    }//end of main
}//end of class

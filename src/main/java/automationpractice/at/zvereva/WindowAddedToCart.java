package automationpractice.at.zvereva;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


public class WindowAddedToCart extends BaseActions {

    private static final By WINDOW_ADDED_TO_CART = By.cssSelector("#layer_cart > div.clearfix");
    private static final By TEXT_INFORMATION = By.cssSelector("div.layer_cart_product.col-xs-12.col-md-6 > h2");
    private static final By CLOSE_BUTTON = By.cssSelector("#layer_cart > div.clearfix > div.layer_cart_product.col-xs-12.col-md-6 > span");

    public WindowAddedToCart(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public boolean checkWindowIsDisplayed() {
        waitABit(3000);
        if (isElementPresent(WINDOW_ADDED_TO_CART) &
                (driver.findElement(WINDOW_ADDED_TO_CART).findElement(TEXT_INFORMATION).getText().
                        equals("Product successfully added to your shopping cart"))) {
            return true;
        }
        return false;
    }

    public void closeWindow() {
        click(CLOSE_BUTTON);
    }
}

package automationpractice.at.zvereva;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class WindowAddedToCart extends BaseActions{

    private static final By WINDOW_ADDED_TO_CART = By.cssSelector("#layer_cart > div.clearfix");
    private static final By TEXT_INFORMATION = By.cssSelector("div.layer_cart_product.col-xs-12.col-md-6 > h2");
    public WindowAddedToCart(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void checkWindowIsDisplayed() {
        Assertions.assertAll(
                ()-> assertTrue(isElementPresent(WINDOW_ADDED_TO_CART), "Не отобразилось окно добавления товара в корзину"),
                ()-> assertEquals(driver.findElement(WINDOW_ADDED_TO_CART).findElement(TEXT_INFORMATION).getText(),"Product successfully added to your shopping cart", "Сообщение отобразилось не корректно")
        );
    }

    public void closeWindow(){

    }


}

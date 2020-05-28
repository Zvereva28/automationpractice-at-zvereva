package automationpractice.at.zvereva;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MyAccountPage extends BaseActions{

    private static final By HISTORY_ORDER_BUTTON = By.cssSelector(".icon-list-ol");
    private static final By MY_CREDITS_SLIPS_BUTTON = By.cssSelector(".icon-ban-circle");
    private static final By MY_ADDRESS_BUTTON = By.cssSelector(".icon-building");
    private static final By MY_PERSONAL_INFORMATION_BUTTON = By.cssSelector(".icon-user");
    private static final By MY_WISH_LISTS_BUTTON = By.cssSelector(".icon-heart");



    public MyAccountPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
    public void checkMyAccountPageIsDisplayed() {
        Assertions.assertAll(
                ()-> assertTrue(isElementPresent(HISTORY_ORDER_BUTTON), "Не отобразилась кнопка HistoryOrder"),
                ()-> assertTrue(isElementPresent(MY_CREDITS_SLIPS_BUTTON), "Не отобразилась кнопка MyCreditSlips"),
                ()-> assertTrue(isElementPresent(MY_ADDRESS_BUTTON), "Не отобразилась кнопка MyAddresses"),
                ()-> assertTrue(isElementPresent(MY_PERSONAL_INFORMATION_BUTTON),"Не отобразилась кнопка MyPersonalInformation"),
                ()-> assertTrue(isElementPresent(MY_WISH_LISTS_BUTTON), "Не отобразилась кнопка MyWishLists")

        );
    }
}

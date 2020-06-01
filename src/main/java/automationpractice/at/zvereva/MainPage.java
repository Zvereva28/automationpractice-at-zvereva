package automationpractice.at.zvereva;

import automationpractice.at.zvereva.BaseActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage extends BaseActions {
    private static final String HOMEPAGE_URL = "http://automationpractice.com/";





    public MainPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void home() {
        driver.get(HOMEPAGE_URL);
    }

    public void clickGoods(){

    }


}

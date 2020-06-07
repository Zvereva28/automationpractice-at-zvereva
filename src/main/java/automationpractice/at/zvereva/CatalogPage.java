package automationpractice.at.zvereva;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class CatalogPage extends BaseActions {
    //ul[class=\"product_list grid row\"] > li
    private static final By PRODUCT_LIST = By.cssSelector("#center_column > ul > li");
    private static final By PRODUCT_NAME = By.cssSelector("a.product-name");
    private static final By FIRST_GOODS_BUTTON = By.cssSelector("#center_column > ul > li:nth-child(1) > div > div.right-block > h5 > a");
    List<WebElement> elements;
    WebElement element;

    public CatalogPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void clickRandomElementCatalogForm() {
        waitABit(5000);
        elements = findElements(PRODUCT_LIST);
        int n = (int) (Math.random() * elements.size());
        System.out.println(n + "++++++++++++++++++");
        scrollPage600();
        new Actions(driver).moveToElement(elements.get(1), 50, 50).click().perform();
    }

    public void clickFirstElementCatalogForm() {
        element = driver.findElement(FIRST_GOODS_BUTTON);
        new Actions(driver).moveToElement(element, 100, 100).click().perform();
    }

}




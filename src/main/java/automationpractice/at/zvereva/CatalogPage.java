package automationpractice.at.zvereva;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.util.List;
import java.util.NoSuchElementException;

import static java.lang.Thread.sleep;

public class CatalogPage extends BaseActions{
    List<WebElement> elements;
    private static final By PRODUCT_LIST = By.cssSelector("#center_column > ul > li");
    //
    private static final By FIRST_GOODS_BUTTON = By.cssSelector("#center_column > ul > li:nth-child(1) > div > div.right-block > h5 > a");



    public CatalogPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void clickRandomElementCatalogForm() throws InterruptedException {
        elements = driver.findElements(PRODUCT_LIST);
        int n = (int)(Math.random() * elements.size());
        System.out.println("номер  " + n);
        Actions actions = new Actions(driver);
        Dimension size = elements.get(n).getSize();
            System.out.println("ширина   "+size.getWidth());
        System.out.println("высота     "+size.getHeight());

        actions.moveToElement(elements.get(n), size.getWidth()%2, (size.getHeight()%2+50)).doubleClick().build().perform();

        }

        public void clickFirstElementCatalogForm(){

            click(FIRST_GOODS_BUTTON);



        }

}




package automationpractice.at.zvereva;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.xml.bind.Element;
import java.util.List;
import java.util.NoSuchElementException;

public abstract class BaseActions {
    WebDriver driver;
    WebDriverWait wait;

    public BaseActions(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void type(String text, By by) {
        if (isElementPresent(by)) {
        WebElement element = driver.findElement(by);
        element.clear();
        element.sendKeys(text);}
        else System.out.println("элемент " + by.toString() + " не найден");
    }

    public void click(By by) {
        if (isElementPresent(by)) {
        driver.findElement(by).click();}
        else System.out.println("элемент " + by.toString() + " не найден ++++++++++++++++++++++++");
    }

    public void clickElementInApt(By by, int index) {
        if (isElementPresent(by)) {
            driver.findElements(by).get(index).click();}
        else System.out.println("элемент " + by.toString() + " не найден ++++++++++++++++++");
    }

    public void waitABit(int sec) {
        try {
            Thread.sleep(sec);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public boolean isElementPresent(By by) {
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(by));
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
    public List<WebElement> findElements(By by) {

            return driver.findElements(by);

    }
}
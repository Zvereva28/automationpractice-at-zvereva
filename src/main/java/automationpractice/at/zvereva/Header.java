package automationpractice.at.zvereva;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Header extends BaseActions{

    private static final By INFORMATION_OF_PAGE = By.cssSelector(".page-heading");

    private static final By SIGN_IN_BTN = By.cssSelector(".login");
    private static final By SIGN_OUT_BTN = By.cssSelector(".logout");

    private static final By BLOCK_TOP_MENU = By.cssSelector("#block_top_menu > ul > li");
    private static final By CARD_BUTTON = By.cssSelector("#header > div:nth-child(3) > div > div > div:nth-child(3) > div > a");
//
    //private static final By HEADER_INFORM_BUTTON = By.cssSelector("#center_column > h1");

    public Header(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void goToSignIn() {
        click(SIGN_IN_BTN);
    }

    public void signOut(){click(SIGN_OUT_BTN);}

    public void goToCard(){
//        WebElement element = driver.findElement(CARD_BUTTON);
//        Actions actions = new Actions(driver);
//        Dimension size = element.getSize();
//        System.out.println("height  "+size.getHeight());
//        actions.moveToElement(element, size.getWidth()%2, (size.getHeight()-20)).click().build().perform();
        click(CARD_BUTTON);
    }

    public boolean checkHeaderInform(String inform){
        waitABit(2000);
       return driver.findElement(INFORMATION_OF_PAGE).getText().toLowerCase().contains(inform);
    }

    public void clickButtonTopMenu(СheckButton nameButton) {
        List<WebElement> elements = findElements(BLOCK_TOP_MENU);
        switch (nameButton) {
            case women: {
                elements.get(0).click();
                break;
            }
            case dresses: {
                elements.get(1).click();
                break;
            }
            case shorts: {
                elements.get(2).click();
                break;
            }
        }
    }
    public enum СheckButton {
        women("WOMEN"),
        dresses("DRESSES"),
        shorts("T-SHORTS");


        private String nameButton;

        СheckButton(String nameButton) {
            this.nameButton = nameButton;
        }

        public String getText() {
            return nameButton;
        }
        }



}

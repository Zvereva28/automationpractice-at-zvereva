package automationpractice.at.zvereva;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoodsPage extends BaseActions {

    private static final By ADD_TI_CARD_BUTTON = By.cssSelector("#add_to_cart > button");
    private static final By QUANTITY_FIELD = By.cssSelector("#quantity_wanted");

    public GoodsPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }


    public void addToCard(int quantity) {
        type(String.valueOf(quantity), QUANTITY_FIELD);
        click(ADD_TI_CARD_BUTTON);

    }

    public void addToCard() {
        type(String.valueOf(1), QUANTITY_FIELD);
        click(ADD_TI_CARD_BUTTON);

    }
}

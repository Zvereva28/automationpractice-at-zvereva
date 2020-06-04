package automationpractice.at.zvereva;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OderPage extends BaseActions{
    private static final By PROCEED_TO_CHECKOUT_SUMMARY = By.cssSelector("#center_column > p.cart_navigation.clearfix > a.button.btn.btn-default.standard-checkout.button-medium");
    private static final By PROCEED_TO_CHECKOUT_ADDRESS = By.cssSelector("#center_column > form > p > button");
    private static final By PROCEED_TO_CHECKOUT_SHIPPING= By.cssSelector("#form > p > button");
    private static final By CHECKBOX_I_AGREE= By.cssSelector("#uniform-cgv");
    private static final By PAY_BY_BANK_WIRE_BUTTON= By.cssSelector("#HOOK_PAYMENT > div:nth-child(1) > div > p > a");

    private static final By I_CONFIRM_MY_ORDER_BUTTON= By.cssSelector("#cart_navigation > button");

    public OderPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void oderConfirmationAlreadyAuth(){
        click(PROCEED_TO_CHECKOUT_SUMMARY);
        click(PROCEED_TO_CHECKOUT_ADDRESS);
        click(CHECKBOX_I_AGREE);
        click(PROCEED_TO_CHECKOUT_SHIPPING);
        click(PAY_BY_BANK_WIRE_BUTTON);
        click(I_CONFIRM_MY_ORDER_BUTTON);
    }
    public void oderConfirmationWithoutAuth1(){
        click(PROCEED_TO_CHECKOUT_SUMMARY);}

    public void oderConfirmationWithoutAuth2(){
        click(PROCEED_TO_CHECKOUT_ADDRESS);
        click(CHECKBOX_I_AGREE);
        click(PROCEED_TO_CHECKOUT_SHIPPING);
        click(PAY_BY_BANK_WIRE_BUTTON);
        click(I_CONFIRM_MY_ORDER_BUTTON);
    }

}

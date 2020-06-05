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
    private static final By PAY_BY__BUTTON= By.cssSelector("#HOOK_PAYMENT > div:nth-child(2) > div > p > a");
    private static final By I_CONFIRM_MY_ORDER_BUTTON= By.cssSelector("#cart_navigation > button");

    public OderPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void oderConfirmationAlreadyAuth(int oneOrTwo){
        proceedCheckoutSummary();
        proceedCheckoutAddress();
        checkboxIAgree();
        proceedCheckoutShipping();
        checkPayment(oneOrTwo);
        confirmMyOder();
    }
    public void proceedCheckoutSummary(){
        click(PROCEED_TO_CHECKOUT_SUMMARY);
    }
    public void proceedCheckoutAddress(){
        click(PROCEED_TO_CHECKOUT_ADDRESS);
    }
    public void checkboxIAgree(){
        click(CHECKBOX_I_AGREE);
    }
    public void proceedCheckoutShipping(){
        click(PROCEED_TO_CHECKOUT_SHIPPING);
    }
    public void checkPayment(int oneOrTwo){
        if (oneOrTwo == 1) {
            click(PAY_BY_BANK_WIRE_BUTTON);}
        else {click(PAY_BY__BUTTON);}
    }

    public void confirmMyOder(){
        click(I_CONFIRM_MY_ORDER_BUTTON);

    }



}

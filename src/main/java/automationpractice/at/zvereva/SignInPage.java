package automationpractice.at.zvereva;
import automationpractice.at.zvereva.BaseActions;
import automationpractice.at.zvereva.data.GenerateData;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SignInPage extends BaseActions {
    //CREATE AN ACCOUNT
    private static final By SIGN_IN_PAGE_HEADER = By.cssSelector(".page-heading");
    private static final By EMAIL_REGISTRATION = By.cssSelector("#email_create");
    private static final By GO_TO_REGISTRATION_BTN = By.cssSelector("#SubmitCreate");
    //ALREADY REGISTERED?
    private static final By EMAIL_ALREADY_REGISTERED_FIELD = By.cssSelector("#email");
    private static final By PASSWORD_ALREADY_REGISTERED_FIELD = By.cssSelector("#passwd");
    private static final By SIGN_IN_BUTTON = By.cssSelector("#SubmitLogin");
    // Предупреждения об ошибках
    private static final By ALERT_DANGER = By.cssSelector("#center_column > div.alert.alert-danger");

    public SignInPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public boolean isSignInPageHeaderPresent() {
        return isElementPresent(SIGN_IN_PAGE_HEADER);
    }

    public String getSignInPageHeaderText() {
        return driver.findElement(SIGN_IN_PAGE_HEADER).getText();
    }

    public void goToRegistration(int emailNameLength) {
        type(GenerateData.generateNewRandomEmail(emailNameLength), EMAIL_REGISTRATION);
        click(GO_TO_REGISTRATION_BTN);
    }
    public void goToRegistration(String email) {
        type(email, EMAIL_REGISTRATION);
        click(GO_TO_REGISTRATION_BTN);
    }
    public void authentication(String email, String password){
        type(email, EMAIL_ALREADY_REGISTERED_FIELD);
        type(password, PASSWORD_ALREADY_REGISTERED_FIELD);
        click(SIGN_IN_BUTTON);
    }
    public void checkDanderAuthentication(String message){
        Assertions.assertTrue(driver.findElement(ALERT_DANGER).getText().contains(message));

    }
}

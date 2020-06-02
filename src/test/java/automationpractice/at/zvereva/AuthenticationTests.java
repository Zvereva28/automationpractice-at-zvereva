package automationpractice.at.zvereva;
import org.junit.jupiter.api.Test;

public class AuthenticationTests extends BaseUITest{

        @Test
        public void positiveAuthenticationTest() {
            mainPage.home();
            header.goToSignIn();
            signInPage.authentication("vskstji@gmail.com","trre123");
            myAccountPage.checkMyAccountPageIsDisplayed();
        }
    @Test
    public void negativeAuthenticationTest() {
        mainPage.home();
        header.goToSignIn();
        signInPage.authentication("vskstji@gmail.com","trre12");
        signInPage.checkDanderAuthentication("Authentication failed");
    }
}

package automationpractice.at.zvereva;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MainPageTests extends BaseUITest{

    @Test
    public void goToSignInPageTest() {
        mainPage.home();
        header.goToSignIn();
        Assertions.assertTrue(signInPage.isSignInPageHeaderPresent());
        Assertions.assertEquals("authentication", signInPage.getSignInPageHeaderText().toLowerCase());
    }
}

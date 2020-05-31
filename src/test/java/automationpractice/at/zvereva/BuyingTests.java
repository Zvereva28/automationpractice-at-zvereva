package automationpractice.at.zvereva;

import automationpractice.at.zvereva.data.GenerateData;
import org.junit.jupiter.api.Test;

import static java.lang.Thread.sleep;

public class BuyingTests extends BaseUITest{
    //dkmfjhg@nhg.iu 123456

    @Test
    public void regAuthBuying() {
        mainPage.home();
        mainPage.goToSignIn();
        String email = GenerateData.generateNewRandomEmail(5);
        signInPage.goToRegistration(email);
        registrationPage.creationAccount(1,
                GenerateData.getNameFromList(),GenerateData.getLastNameFromList() ,
                "123456",
                "Wall Street, 25",
                "Moskow",
                36,
                "00123",
                "259-365");
        myAccountPage.checkMyAccountPageIsDisplayed();
//выйти из аккаунта
        mainPage.signOut();
        mainPage.home();
        mainPage.goToSignIn();
        signInPage.authentication(email,"123456");
        myAccountPage.checkMyAccountPageIsDisplayed();


    }
}

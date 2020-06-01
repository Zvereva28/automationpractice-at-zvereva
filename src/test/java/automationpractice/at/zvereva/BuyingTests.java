package automationpractice.at.zvereva;

import automationpractice.at.zvereva.data.GenerateData;
import org.junit.jupiter.api.Test;

import static java.lang.Thread.sleep;

public class BuyingTests extends BaseUITest{
    //dkmfjhg@nhg.iu 123456

    @Test
    public void regAuthBuying() throws InterruptedException {
        mainPage.home();
        header.goToSignIn();
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
        header.signOut();
        mainPage.home();
        header.goToSignIn();
        signInPage.authentication(email,"123456");
        myAccountPage.checkMyAccountPageIsDisplayed();
        header.clickButtonTopMenu(Header.СheckButton.dresses);
        sleep(5000);
        catalogPage.clickRandomElementCatalogForm();
        sleep(5000);
        goodsPage.addToCard(2);
        sleep(5000);



    }
    @Test
    public void authBuying() throws InterruptedException {
        mainPage.home();
//        header.goToSignIn();
//        signInPage.authentication("dkmfjhg@nhg.iu","123456");
//        myAccountPage.checkMyAccountPageIsDisplayed();
        header.clickButtonTopMenu(Header.СheckButton.dresses);
        sleep(2000);
        catalogPage.clickRandomElementCatalogForm();
        sleep(2000);
        goodsPage.addToCard(2);
        sleep(2000);
        windowAddedToCart.checkWindowIsDisplayed();
        sleep(2000);
        windowAddedToCart.closeWindow();
        sleep(2000);



    }
}

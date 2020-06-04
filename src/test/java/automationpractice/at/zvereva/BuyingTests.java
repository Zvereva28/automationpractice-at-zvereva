package automationpractice.at.zvereva;
import automationpractice.at.zvereva.data.GenerateData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
//dkmfjhg@nhg.iu 123456

public class BuyingTests extends BaseUITest{

    @DisplayName("Регистрация + аутентификация + покупка")
    @Test
    public void regAuthBuying() {
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
        header.clickButtonTopMenu(Header.СheckButton.women);
        catalogPage.clickRandomElementCatalogForm();
        goodsPage.addToCard(3);
        windowAddedToCart.checkWindowIsDisplayed();
        windowAddedToCart.closeWindow();
        header.goToCard();
        oderPage.oderConfirmationAlreadyAuth();
        Assertions.assertTrue(header.checkHeaderInform("order confirmation"),
                "ожидаемое сообщение в хэдере \"order confirmation\"");


    }

    @DisplayName("Аутентификация + покупка")
    @Test
    public void authBuying() {
        mainPage.home();
        header.goToSignIn();
        signInPage.authentication("dkmfjhg@nhg.iu","123456");
        myAccountPage.checkMyAccountPageIsDisplayed();
        header.clickButtonTopMenu(Header.СheckButton.dresses);
        catalogPage.clickRandomElementCatalogForm();
        goodsPage.addToCard(2);
        windowAddedToCart.checkWindowIsDisplayed();
        windowAddedToCart.closeWindow();
        header.goToCard();
        oderPage.oderConfirmationAlreadyAuth();
        Assertions.assertTrue(header.checkHeaderInform("order confirmation"),
                "ожидаемое сообщение в хэдере \"order confirmation\"");
    }

    @DisplayName("Покупка + аутентификация")
    @Test
    public void authBuying2() throws InterruptedException {
        mainPage.home();
        header.clickButtonTopMenu(Header.СheckButton.women);
        catalogPage.clickRandomElementCatalogForm();
        goodsPage.addToCard(2);
        windowAddedToCart.checkWindowIsDisplayed();
        windowAddedToCart.closeWindow();
        header.goToCard();
        oderPage.oderConfirmationWithoutAuth1();
        signInPage.authentication("dkmfjhg@nhg.iu", "123456");
        oderPage.oderConfirmationWithoutAuth2();
        Assertions.assertTrue(header.checkHeaderInform("order confirmation"),
                "ожидаемое сообщение в хэдере \"order confirmation\"");


    }
}

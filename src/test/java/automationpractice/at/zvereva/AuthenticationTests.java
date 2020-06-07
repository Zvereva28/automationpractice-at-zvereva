package automationpractice.at.zvereva;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class AuthenticationTests extends BaseUITest {
    @DataProvider(name = "dataTest")
    public static Object[][] dataForNegativeAuthTest() {
        return new Object[][]{
                {"vskstji@gmai.com", "123456", "authentication failed"},
                {"vskstji@gmai.com", "12", "invalid password"},
                {"gjnvd3", "123456", "email address"}
        };
    }

    @Test(testName = "Аутентификация с валидными данными (позитив)")
    public void positiveAuthTest() {
        mainPage.home();
        header.goToSignIn();
        signInPage.authentication("vskstji@gmail.com", "trre123");
        Assert.assertTrue(myAccountPage.checkMyAccountPageIsDisplayed(), "не все элементы MyAccount отобразились");
    }

    @Test(testName = "Аутентификация с не валидными данными (негатив)", dataProvider = "dataTest")
    public void negativeAuthTest(Object email, Object password, Object message) {
        mainPage.home();
        header.goToSignIn();
        signInPage.authentication(email.toString(), password.toString());
        Assert.assertTrue(signInPage.checkDanderAuthentication().contains(message.toString().toLowerCase()),
                "сообщение не содежит " + message);

    }
}


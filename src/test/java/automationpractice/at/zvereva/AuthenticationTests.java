package automationpractice.at.zvereva;

import automationpractice.at.zvereva.data.GenerateData;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class AuthenticationTests extends BaseUITest {

    @DataProvider(name = "dataTest")
    public static Object[][] dataForNegativeAuthTest() {
        return new Object[][]{
                {GenerateData.AUTH_NEGATIVE1[0], GenerateData.AUTH_NEGATIVE1[1], SignInPage.AUTHENTICATION_FAILED_ALERT},
                {GenerateData.AUTH_NEGATIVE2[0], GenerateData.AUTH_NEGATIVE2[1],  SignInPage.INVALID_PASSWORD_ALERT},
                {GenerateData.AUTH_NEGATIVE3[0], GenerateData.AUTH_NEGATIVE3[1], SignInPage.INVALID_EMAIL_ALERT}
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


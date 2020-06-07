package automationpractice.at.zvereva;

import org.testng.Assert;
import org.testng.annotations.Test;

public class MainPageTests extends BaseUITest {

    @Test(testName = "Загрузка страницы регистрации")
    public void goToSignInPageTest() {
        mainPage.home();
        header.goToSignIn();
        Assert.assertTrue(header.checkHeaderInform("authentication"), "проверка заголовка не  прошла");
    }
}

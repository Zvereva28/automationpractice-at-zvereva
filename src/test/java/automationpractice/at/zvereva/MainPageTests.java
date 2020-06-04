package automationpractice.at.zvereva;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MainPageTests extends BaseUITest{
    @DisplayName("Загрузка страницы регистрации")
    @Test
    public void goToSignInPageTest() {
        mainPage.home();
        header.goToSignIn();

        Assertions.assertTrue(header.checkHeaderInform("authentication"), "проверка заголовка не  прошла");
    }
}

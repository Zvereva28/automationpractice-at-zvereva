package automationpractice.at.zvereva;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;

public class AuthenticationTests extends BaseUITest{
    @DisplayName("Аутентификация с валидными данными (позитив)")
        @Test
        public void positiveAuthTest() {
            mainPage.home();
            header.goToSignIn();
            signInPage.authentication("vskstji@gmail.com","trre123");
            myAccountPage.checkMyAccountPageIsDisplayed();
        }
    @DisplayName("Аутентификация с не валидными данными (негатив)")
    @ParameterizedTest
    @MethodSource("dataForNegativeAuthTest")
    public void negativeAuthTest(String email, String password, String message)  {
        mainPage.home();
        header.goToSignIn();
        signInPage.authentication(email,password);
        Assertions.assertTrue(signInPage.checkDanderAuthentication().contains(message.toLowerCase()),
                "сообщение не содежит " + message);

    }

    public static Stream<Arguments> dataForNegativeAuthTest(){
        return Stream.of(
                Arguments.of("vskstji@gmai.com", "123456", "authentication failed"),
                Arguments.of("vskstji@gmai.com", "12", "invalid password"),
                Arguments.of("gjnvd3", "123456", "email address")
        );
    }
    }


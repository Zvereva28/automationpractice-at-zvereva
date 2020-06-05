package automationpractice.at.zvereva;
import automationpractice.at.zvereva.data.GenerateData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static java.lang.Thread.sleep;

public class RegistrationTests extends BaseUITest {
    @DisplayName("Создание нового аккаунта, все данные валидные (позитив)")
    @ParameterizedTest
    @MethodSource("dataForTest1")
    public void createNewAccountPositiveTest(
            int oneOrTwo,
            String password,
            String address,
            String city,
            int indexOfState,
            String postCode,
            String phone) throws InterruptedException {
        mainPage.home();
        header.goToSignIn();
        signInPage.goToRegistration(7);

        registrationPage.creationAccount(oneOrTwo, GenerateData.getNameFromList(),GenerateData.getLastNameFromList() ,password, address, city,indexOfState,postCode, phone);
        sleep(3000);
        Assertions.assertTrue(myAccountPage.checkMyAccountPageIsDisplayed(), "не все элементы MyAccount отобразились");

    }
    public static Stream<Arguments> dataForTest1(){
        return Stream.of(
                Arguments.of(1, "trre123", "street 25", "NewYork", 25, "25002", "25"),
                Arguments.of(2, "nhyt3698", "street 15", "Volgograd", 15, "36523", "36-96-36"),
                Arguments.of(1, "gjnvd3", "street 5", "Moscow", 16, "36555", "369-96-36")
        );
    }
    @DisplayName("Создание нового аккаунта, данные не валидные (негатив) проверка информационных сообщений")
    @ParameterizedTest
    @MethodSource("dataForTest2")
    public void createNewAccountNegativeTest1(
            int oneOrTwo,
            String firstName,
            String lastName,
            String password,
            String address,
            String city,
            int indexOfState,
            String postCode,
            String phone,
            String danger) throws InterruptedException {
        mainPage.home();
        header.goToSignIn();
        signInPage.goToRegistration(10);
        registrationPage.creationAccount(oneOrTwo,firstName,lastName, password, address, city, indexOfState, postCode, phone);
        sleep(3000);
        registrationPage.checkAlertInformation(danger);
    }


    public static Stream<Arguments> dataForTest2(){
        return Stream.of(
                Arguments.of(1,"Nina","Fan", "treo123", "street 25", "NewYork", 25, "250", "25","The Zip/Postal code you've entered is invalid. It must follow this format: 00000"),
                Arguments.of(2, "Nina","Fan","98", "street 15", "Volgograd", 15, "52305", "36-96-36", "passwd is invalid."),
                Arguments.of(1,"Nina","Fan", "gjnvd3", "street 5", "Moscow", 16, "36555", "", "You must register at least one phone number"),
                Arguments.of(1,"Nina36","Fan", "gjnvd3", "street 5", "Moscow", 16, "36555", "36-98-7", "firstname is invalid"),
                Arguments.of(2,"Nina","", "25698746", "street 5", "Moscow", 16, "36555", "36-98-7", "lastname")

        );
    }

}
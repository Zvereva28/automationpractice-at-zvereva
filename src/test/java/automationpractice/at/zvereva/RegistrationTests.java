package automationpractice.at.zvereva;

import automationpractice.at.zvereva.data.GenerateData;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static java.lang.Thread.sleep;

public class RegistrationTests extends BaseUITest {
    @DataProvider(name = "dataTest1")
    public static Object[][] dataForTest() {
        return new Object[][]{
                {1, "trre123", "street 25", "NewYork", 25, "25002", "25"},
                {2, "nhyt3698", "street 15", "Volgograd", 15, "36523", "36-96-36"},
                {1, "gjnvd3", "street 5", "Moscow", 16, "36555", "369-96-36"}
        };
    }

    @DataProvider(name = "dataTest2")
    public static Object[][] dataForTest2() {
        return new Object[][]{
                {1, "Nina", "Fan", "treo123", "street 25", "NewYork", 25, "250", "25", "The Zip/Postal code you've entered is invalid. It must follow this format: 00000"},
                {2, "Nina", "Fan", "98", "street 15", "Volgograd", 15, "52305", "36-96-36", "passwd is invalid."},
                {1, "Nina", "Fan", "gjnvd3", "street 5", "Moscow", 16, "36555", "", "You must register at least one phone number"},
                {1, "Nina36", "Fan", "gjnvd3", "street 5", "Moscow", 16, "36555", "36-98-7", "firstname is invalid"},
                {2, "Nina", "", "25698746", "street 5", "Moscow", 16, "36555", "36-98-7", "lastname"}
        };
    }

    @Test(testName = "Создание нового аккаунта, все данные валидные (позитив)",
            dataProvider = "dataTest1")
    public void createNewAccountPositiveTest(
            Object oneOrTwo,
            Object password,
            Object address,
            Object city,
            Object indexOfState,
            Object postCode,
            Object phone) throws InterruptedException {
        mainPage.home();
        header.goToSignIn();
        signInPage.goToRegistration(7);

        registrationPage.creationAccount(Integer.parseInt(oneOrTwo.toString()),
                GenerateData.getNameFromList(),
                GenerateData.getLastNameFromList(),
                password.toString(),
                address.toString(),
                city.toString(),
                Integer.parseInt(indexOfState.toString()),
                postCode.toString(),
                phone.toString());
        sleep(3000);
        Assert.assertTrue(myAccountPage.checkMyAccountPageIsDisplayed(), "не все элементы MyAccount отобразились");
    }

    @Test(testName = "Создание нового аккаунта, данные не валидные (негатив) проверка информационных сообщений",
            dataProvider = "dataTest2")
    public void createNewAccountNegativeTest1(
            Object oneOrTwo,
            Object firstName,
            Object lastName,
            Object password,
            Object address,
            Object city,
            Object indexOfState,
            Object postCode,
            Object phone,
            Object danger) throws InterruptedException {
        mainPage.home();
        header.goToSignIn();
        signInPage.goToRegistration(10);
        registrationPage.creationAccount(Integer.parseInt(oneOrTwo.toString()),
                firstName.toString(),
                lastName.toString(),
                password.toString(),
                address.toString(),
                city.toString(),
                Integer.parseInt(indexOfState.toString()),
                postCode.toString(),
                phone.toString());
        sleep(3000);
        Assert.assertTrue(registrationPage.checkAlertInformation(danger.toString()), "проверка сообщений об ошибке");
    }
}
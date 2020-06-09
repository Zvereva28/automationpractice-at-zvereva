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
                {GenerateData.AI_POSITIVE1[0], GenerateData.AI_POSITIVE1[1], GenerateData.AI_POSITIVE1[2],
                        GenerateData.AI_POSITIVE1[3], GenerateData.AI_POSITIVE1[4], GenerateData.AI_POSITIVE1[5],
                        GenerateData.AI_POSITIVE1[6]},
                {GenerateData.AI_POSITIVE2[0], GenerateData.AI_POSITIVE2[1], GenerateData.AI_POSITIVE2[2],
                        GenerateData.AI_POSITIVE2[3], GenerateData.AI_POSITIVE2[4], GenerateData.AI_POSITIVE2[5],
                        GenerateData.AI_POSITIVE2[6]},
                {GenerateData.AI_POSITIVE3[0], GenerateData.AI_POSITIVE3[1], GenerateData.AI_POSITIVE3[2],
                        GenerateData.AI_POSITIVE3[3], GenerateData.AI_POSITIVE3[4], GenerateData.AI_POSITIVE3[5],
                        GenerateData.AI_POSITIVE3[6]}
        };
    }

    @DataProvider(name = "dataTest2")
    public static Object[][] dataForTest2() {
        return new Object[][]{
                {1, "Nina", "Fan", "treo123", "street 25", "NewYork", 25, "250", "25", RegistrationPage.AI_POST_CODE},
                {2, "Nina", "Fan", "98", "street 15", "Volgograd", 15, "52305", "36-96-36", RegistrationPage.AI_PASSWORD_INVALID},
                {1, "Nina", "Fan", "gjnvd3", "street 5", "Moscow", 16, "36555", "", RegistrationPage.AI_REGISTER_PHONE},
                {1, "Nina36", "Fan", "gjnvd3", "street 5", "Moscow", 16, "36555", "36-98-7", RegistrationPage.AI_FIRST_NAME_INVALID},
                {2, "Nina", "", "25698746", "street 5", "Moscow", 16, "36555", "36-98-7", RegistrationPage.AI_LAST_NAME_REQUIRED}
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
        Assert.assertTrue(registrationPage.checkAlertInformation(danger.toString()), "проверка сообщений об ошибке, нет сообщения" + danger.toString());
    }
}
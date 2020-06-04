package automationpractice.at.zvereva;

import automationpractice.at.zvereva.BaseActions;
import automationpractice.at.zvereva.data.GenerateData;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class RegistrationPage extends BaseActions {

    //++++++++++++++++++++++++++++++++++++++YOUR PERSONAL INFORMATION
    private static final By MR_RADIO_BUTTON = By.cssSelector("#id_gender1");
    private static final By MRS_RADIO_BUTTON = By.cssSelector("#id_gender2");
    private static final By FIRST_NAME_CUSTOMER_FIELD = By.cssSelector("#customer_firstname");
    private static final By LAST_NAME_CUSTOMER_FIELD = By.cssSelector("#customer_lastname");
    private static final By EMAIL_FIELD = By.cssSelector("#email");
    private static final By PASSWORD_FIELD = By.cssSelector("#passwd");
    //+++++++++++++++++++++++++++++++++++++++++++Date of Birth
    private static final By DAY_OF_BIRTH_FIELD = By.cssSelector("#days");
    private static final By MONTHS_OF_BIRTH_FIELD = By.cssSelector("#months");
    private static final By YEARS_OF_BIRTH_FIELD = By.cssSelector("#years");
    private static final By NEWSLETTER_FIELD = By.cssSelector("#newsletter");
    private static final By SPECIAL_OFFERS_FIELD = By.cssSelector("#optin");
    //+++++++++++++++++++++++++++++++++++++++++++++YOUR ADDRESS
    private static final By NAME_FIELD = By.cssSelector("#firstname");
    private static final By LAST_NAME_FIELD = By.cssSelector("#lastname");
    private static final By COMPANY_FIELD = By.cssSelector("#company");
    private static final By ADDRESS1_FIELD = By.cssSelector("#address1");
    private static final By ADDRESS2_FIELD = By.cssSelector("#address2");
    private static final By CITY_FIELD = By.cssSelector("#city");
    private static final By STATE_FIELD = By.cssSelector("#id_state");//--------ВЫПАДАЮЩИЙ СПИСОК
    private static final By STATE_APT = By.cssSelector("#id_state > option");//+++++++++++ВЫПАДАЮЩИЙ СПИСОК

    private static final By POST_CODE_FIELD = By.cssSelector("#postcode");
    private static final By COUNTRY_FIELD = By.cssSelector("#id_country");
    private static final By COUNTRY_USA = By.cssSelector("#id_country > option:nth-child(2)");

    private static final By FIELD_ADDITIONAL_INFORMATION = By.cssSelector("#other");
    private static final By FIELD_HOME_PHONE = By.cssSelector("#phone");
    private static final By FIELD_MOBILE_PHONE = By.cssSelector("#phone_mobile");
    private static final By FIELD_ADDRESS_ALIAS = By.cssSelector("#alias");

    private static final By REGISTER_BUTTON = By.cssSelector("#submitAccount");

    private static final By INFORMATION_ALERT = By.cssSelector("#center_column > div");

    private static final By INFORMATION_ALERT_DOWN = By.cssSelector("#account-creation_form > div.submit.clearfix > p");


    public RegistrationPage(WebDriver driver, WebDriverWait wait) {

        super(driver, wait);
    }

    public void creationAccount(
            int oneOrTwo,
            String firstName,
            String lastName,
            String password,
            String address,
            String city,
            int indexOfState,
            String postCode,
            String phone) {
        //пока так
        if (oneOrTwo == 1){
        click(MR_RADIO_BUTTON);}
        else click(MRS_RADIO_BUTTON);
        type(firstName,FIRST_NAME_CUSTOMER_FIELD);
        type(lastName,LAST_NAME_CUSTOMER_FIELD);
        type(password, PASSWORD_FIELD);
        type(address, ADDRESS1_FIELD);
        type(city, CITY_FIELD);
        //click(STATE_FIELD);
        clickElementInApt(STATE_APT,indexOfState);
        //click(COUNTRY_FIELD);
        click(COUNTRY_USA);
        type(postCode, POST_CODE_FIELD);
        type(phone,FIELD_HOME_PHONE);
        click(REGISTER_BUTTON);
    }

    public void checkAlertInformation(String str){
        Assertions.assertAll(
                ()-> assertTrue(driver.findElement(INFORMATION_ALERT).getText().contains(str)),
                ()-> assertTrue(driver.findElement(INFORMATION_ALERT_DOWN).getText().contains("Required field"))
        );


    }
}

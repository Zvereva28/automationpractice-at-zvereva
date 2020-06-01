package automationpractice.at.zvereva;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Header extends BaseActions{

    private static final By SIGN_IN_BTN = By.cssSelector(".login");
    private static final By SIGN_OUT_BTN = By.cssSelector(".logout");

    private static final By BLOCK_TOP_MENU = By.cssSelector("#block_top_menu > ul > li");



    public Header(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void goToSignIn() {
        click(SIGN_IN_BTN);
    }

    public void signOut(){click(SIGN_OUT_BTN);}

    public void clickButtonTopMenu(СheckButton nameButton) {
        List<WebElement> elements = findElements(BLOCK_TOP_MENU);
        switch (nameButton) {
            case women: {
                elements.get(0).click();
                break;
            }
            case dresses: {
                elements.get(1).click();
                break;
            }
            case shorts: {
                elements.get(2).click();
                break;
            }
        }
    }
    public enum СheckButton {
        women("WOMEN"),
        dresses("DRESSES"),
        shorts("T-SHORTS");


        private String nameButton;

        СheckButton(String nameButton) {
            this.nameButton = nameButton;
        }

        public String getText() {
            return nameButton;
        }
        }

}
//
//    @Step("Выбор пункта {nameButton} в фильтре checkBox")
//    public CoursesPage checkBox(СheckBoxButton nameButton) {
//        switch (nameButton) {
//            case checkBoxFree: {
//                checkBoxFree.click();
//                break;
//            }
//            case checkBoxForStart: {
//                checkBoxForStart.click();
//                break;
//            }
//            case checkBoxWebDevel: {
//                checkBoxWebDevel.click();
//                break;
//            }
//            case checkBoxProgramDevel: {
//                checkBoxProgramDevel.click();
//                break;
//            }
//            case checkBoxWebDesign: {
//                checkBoxWebDesign.click();
//                break;
//            }
//            case checkBoxMobileDevel: {
//                checkBoxMobileDevel.click();
//                break;
//              }
//            }

//public enum СheckBoxButton{
//    checkBoxFree("Бесплатные"),
//    checkBoxForStart("Для начинающих"),
//    checkBoxWebDevel("Веб-разработка"),
//    checkBoxProgramDevel("Разработка программ"),
//    checkBoxWebDesign("Веб-дизайн"),
//    checkBoxMobileDevel("Мобильная разработка"),
//    checkBoxGameDevel("Разработка игр"),
//    checkBoxInformationSecurity("Информационная безопасность"),
//    checkBoxDataScience("Data Science"),
//    checkBoxTesting("Тестирование"),
//    checkBoxInternetMarketing("Интернет маркетинг"),
//    checkBoxSystemAdministration("Системное администрирование"),
//    checkBoxGeekClub("GeekClub"),
//    checkBoxCyberSport("Киберспорт");
//
//    private String nameButton;
//
//    СheckBoxButton(String nameButton) {
//        this.nameButton = nameButton;
//    }
//
//    public String getText() {
//        return nameButton;
//    }
//}
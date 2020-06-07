package automationpractice.at.zvereva;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.util.concurrent.TimeUnit;

public class BaseUITest {
    public WebDriver driver;
    protected WebDriverWait wait;
    protected MainPage mainPage;
    protected SignInPage signInPage;
    protected RegistrationPage registrationPage;
    protected MyAccountPage myAccountPage;
    protected Header header;
    protected CatalogPage catalogPage;
    protected GoodsPage goodsPage;
    protected WindowAddedToCart windowAddedToCart;
    protected OderPage oderPage;

    @BeforeSuite
    public void init() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(20, TimeUnit.SECONDS);

        wait = new WebDriverWait(driver, 3);
        mainPage = new MainPage(driver, wait);
        signInPage = new SignInPage(driver, wait);
        registrationPage = new RegistrationPage(driver, wait);
        myAccountPage = new MyAccountPage(driver, wait);
        header = new Header(driver, wait);
        catalogPage = new CatalogPage(driver, wait);
        goodsPage = new GoodsPage(driver, wait);
        windowAddedToCart = new WindowAddedToCart(driver, wait);
        oderPage = new OderPage(driver, wait);
    }

    @AfterSuite
    public void shutdown() {
        driver.quit();
    }
}
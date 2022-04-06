package yandexmarket;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {

    public WebDriver webDriver;
    protected static final String BASE_URL = "https://market.yandex.ru/";

    @BeforeTest
    public void setup() {
//        Пробуем открыть профиль
//        FirefoxProfile profile = new FirefoxProfile();
//        profile.setPreference("profile", "src/test/resources/rz9mo2sv.default");
        FirefoxOptions capabilities = new FirefoxOptions();
//        capabilities.setProfile(profile);
        System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver.exe");
        webDriver = new FirefoxDriver();
        webDriver.get(BASE_URL);
        webDriver.manage().window().maximize();
    }

    @AfterTest
    public void quit() {
//        чистим кэш и куки
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) webDriver;
        webDriver.manage().deleteAllCookies();
        javascriptExecutor.executeScript("window.sessionStorage.clear()");
        webDriver.quit();
    }


}

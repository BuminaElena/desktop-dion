package yandexmarket;

import Pages.BasePage;
import Pages.YandexMarketPage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {

    public WebDriver webDriver;
    protected static final String BASE_URL = "https://market.yandex.ru/";

    @BeforeTest
    public void setup() {
        System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver.exe");
        webDriver = new FirefoxDriver();
        webDriver.get(BASE_URL);
        webDriver.manage().window().maximize();
    }

    @AfterTest
    public void quit() {
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) webDriver;
        webDriver.manage().deleteAllCookies();
        javascriptExecutor.executeScript("window.sessionStorage.clear()");
        webDriver.quit();
    }


}

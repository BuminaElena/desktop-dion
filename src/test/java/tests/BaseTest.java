package tests;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {

    public WebDriver webDriver;

    @BeforeTest
    public void setup() {
        ChromeOptions opt = new ChromeOptions();
        opt.setBinary("C:\\Users\\user\\AppData\\Local\\Programs\\dion\\dion.exe");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("chromeOptions", opt);
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver106.exe");
        webDriver = new ChromeDriver(capabilities);
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

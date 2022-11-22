package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DionGreetingPage extends BasePage{
    public DionGreetingPage(WebDriver webDriver) {
        super(webDriver);
    }

    private static final By TO_AUTH = By.xpath("//a[@id='go-to-login']");
    private static final By EMAIL = By.xpath("//input[@id='email']");
    private static final By PASSWORD = By.xpath("//input[@id='password']");
    private static final By LOGIN_BUTTON = By.xpath("//button[@id='login-button']");

    public void goToLogin() {
        waitForElementIsClicable(TO_AUTH).click();
    }

    public void auth(String email, String password) {
        waitForElementIsVisible(EMAIL).sendKeys(email);
        waitForElementIsVisible(PASSWORD).sendKeys(password);
        waitForElementIsClicable(LOGIN_BUTTON).click();
    }
}

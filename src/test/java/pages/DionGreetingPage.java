package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.sbtqa.tag.pagefactory.annotations.ElementTitle;
import ru.sbtqa.tag.pagefactory.annotations.PageEntry;

public class DionGreetingPage extends BasePage{
    public DionGreetingPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    @ElementTitle(value = "Войти для авторизации")
    @FindBy(xpath = "//a[@id='go-to-login']")
    private WebElement goToLogin;

    @ElementTitle(value = "Логин")
    @FindBy(xpath = "//input[@id='email']")
    private WebElement loginInput;

    @ElementTitle(value = "Пароль")
    @FindBy(xpath = "//input[@id='password']")
    private WebElement passwordInput;

    @ElementTitle(value = "Войти")
    @FindBy(xpath = "//button[@id='login-button']")
    private WebElement loginButton;

    public void goToLogin() {
        goToLogin.click();
    }

    public void auth(String email, String password) {
        loginInput.sendKeys(email);
        passwordInput.sendKeys(password);
        loginButton.click();
    }
}

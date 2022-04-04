package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    protected WebDriver webDriver;

    public BasePage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public WebElement waitForElementIsClicable(By by) {
        WebElement element = new WebDriverWait(webDriver, Duration.ofSeconds(20))
                .until(ExpectedConditions.elementToBeClickable(by));
        return element;
    }

    public WebElement waitForElementIsVisible(By by) {
        WebElement element = new WebDriverWait(webDriver, Duration.ofSeconds(20))
                .until(ExpectedConditions.visibilityOfElementLocated(by));
        return element;
    }


}

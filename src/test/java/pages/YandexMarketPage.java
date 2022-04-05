package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class YandexMarketPage extends BasePage {

    public YandexMarketPage(WebDriver webDriver) {super(webDriver);}

    private static final By CAPTCHA = By.xpath("//input[@class='CheckboxCaptcha-Button']");
    private static final By CATALOG = By.id("catalogPopupButton");
    private static final By PRICE = By.xpath("//legend[text()='Цена, ₽']");
    private static final By MIN_PRICE = By.name("Цена от");
    private static final By MAX_PRICE = By.name("Цена до");
    private static final By DELIVERY_TYPE = By.xpath("//legend[text()='Способ доставки']");
    private static final By MANUFACTURER_SHOW_ALL = By.xpath("//legend[text()='Производитель']/parent::*//button");
    private static final By SEARCH_FIELD = By.xpath("//input[@name='Поле поиска']");
    private static final By SPINNER = By.xpath("//div[@aria-label='Результаты поиска']/div[@data-tid]");
    private static final By FIRST_FOUND_PRODUCT = By.xpath("//div[@data-zone-name='SearchPartition']//a");

    public void processCaptcha() throws InterruptedException {
        try {
            if (webDriver.findElement(CAPTCHA).isDisplayed()) {
                webDriver.findElement(CAPTCHA).click();
                System.out.println("Обработали капчу");
            }
        } catch (NoSuchElementException e) {
            System.out.println("Нет капчи");
        }
        Thread.sleep(5000);
    }

    public void goToCatalog() {
        waitForElementIsClicable(CATALOG).click();
    }

    public void moveToLeftMenuItem(String menuItem) {
        Actions actions = new Actions(webDriver);
        WebElement menuElement = waitForElementIsClicable(By.xpath("//span[text()='" + menuItem +"']"));
        actions.moveToElement(menuElement).build().perform();
    }

    public void goToCatalogSection(String section, String subsection) {
        waitForElementIsVisible(By.xpath("//a[text()='"+section+"']"));
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView();", webDriver.findElement(By.xpath("//a[text()='"+section+"']")));
        webDriver.findElement(By.xpath("//a[text()='"+section+"']/parent::*/following-sibling::*//a[text()='"+subsection+"']")).click();
    }

    public void enterPrice(String minPrice, String maxPrice) {
        waitForElementIsVisible(PRICE);
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView({block:\"center\"});", webDriver.findElement(PRICE));
        webDriver.findElement(MIN_PRICE).sendKeys(minPrice);
        webDriver.findElement(MAX_PRICE).sendKeys(maxPrice);
    }

    public void selectDeliveryType(String deliveryType) {
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView({block:\"center\"});", webDriver.findElement(DELIVERY_TYPE));
        webDriver.findElement(By.xpath("//span[text()='"+deliveryType+"']/ancestor::label")).click();
    }

    public void selectManufacturer(String manufacturer) {
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView({block:\"center\"});", webDriver.findElement(MANUFACTURER_SHOW_ALL));
        waitForElementIsClicable(MANUFACTURER_SHOW_ALL).click();
        waitForElementIsClicable(SEARCH_FIELD).sendKeys(manufacturer);
        waitForElementIsClicable(By.xpath("//input[@name='Производитель "+manufacturer+"']/parent::label")).click();
    }

    public void openFirstFoundProduct() {
        Boolean waitFlag = new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.invisibilityOfElementLocated(SPINNER));
        if (waitFlag == true) {
            webDriver.findElement(FIRST_FOUND_PRODUCT).click();
        } else {
            System.out.println("не нашли товар согласно фильтрам");}
        for (String windowHandle : webDriver.getWindowHandles()) {
            webDriver.switchTo().window(windowHandle);
        }
    }
}

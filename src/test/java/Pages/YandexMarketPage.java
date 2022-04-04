package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

public class YandexMarketPage extends BasePage {

    public YandexMarketPage(WebDriver webDriver) {super(webDriver);}

    private static final By CAPTCHA = By.xpath("//input[@class='CheckboxCaptcha-Button']");
    private static final By LOGO_MARKET = By.id("logoPartMarket");
    private static final By ENTER = By.xpath("//span[text()='Войти']");
    private static final By LOGIN = By.name("login");
    private static final By PASSWORD = By.name("passwd");
    private static final By ENTER_SUBMIT = By.id("passp:sign-in");
    private static final By CATALOG = By.id("catalogPopupButton");
    private static final By PRICE = By.xpath("//legend[text()='Цена, ₽']");
    private static final By MIN_PRICE = By.name("Цена от");
    private static final By MAX_PRICE = By.name("Цена до");
    private static final By DELIVERY_TYPE = By.xpath("//legend[text()='Способ доставки']");
    private static final By MANUFACTURER_SHOW_ALL = By.xpath("//legend[text()='Производитель']/parent::*//button");
    private static final By SEARCH_FIELD = By.xpath("//input[@name='Поле поиска']");
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

    public void enterToProfile() throws InterruptedException {
        waitForElementIsClicable(ENTER).click();
        waitForElementIsClicable(LOGIN).sendKeys("hgfyugjs756@yandex.ru");
        waitForElementIsClicable(ENTER_SUBMIT).click();
        waitForElementIsClicable(PASSWORD).sendKeys("vsgadad845");
        waitForElementIsClicable(ENTER_SUBMIT).click();
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
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView({block:\"center\"});", webDriver.findElement(PRICE));
        webDriver.findElement(MIN_PRICE).sendKeys(minPrice);
        webDriver.findElement(MAX_PRICE).sendKeys(maxPrice);
    }

    public void selectDeliveryType(String deliveryType) {
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView({block:\"center\"});", webDriver.findElement(DELIVERY_TYPE));
        webDriver.findElement(By.xpath("//span[text()='"+deliveryType+"']/ancestor::label")).click();
    }

    public void selectManufacturer(String manufacturer) throws InterruptedException {
//        Thread.sleep(10000);
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView({block:\"center\"});", webDriver.findElement(MANUFACTURER_SHOW_ALL));
//        Thread.sleep(10000);
        waitForElementIsClicable(MANUFACTURER_SHOW_ALL).click();
//        Thread.sleep(10000);
        waitForElementIsClicable(SEARCH_FIELD).sendKeys(manufacturer);
        waitForElementIsClicable(By.xpath("//input[@name='Производитель "+manufacturer+"']/parent::label")).click();
        Thread.sleep(2000);
    }

    public void openFirstFoundProduct() {
        waitForElementIsVisible(FIRST_FOUND_PRODUCT);
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView({block:\"center\"});", webDriver.findElement(FIRST_FOUND_PRODUCT));
        waitForElementIsClicable(FIRST_FOUND_PRODUCT).click();
        for (String windowHandle : webDriver.getWindowHandles()) {
            webDriver.switchTo().window(windowHandle);
        }
    }

}

package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ProductCard extends BasePage{

    public ProductCard (WebDriver webDriver) {super(webDriver);}

    private static final By COMPARE = By.xpath("//span[text()='Сравнить']/parent::div");
    private static final By POPUP_INFORMER = By.xpath("//div[@data-apiary-widget-name='@marketfront/PopupInformer']");

    public void compareProduct() throws InterruptedException {
        waitForElementIsClicable(COMPARE).click();
//        webDriver.findElement(COMPARE).click();
        Thread.sleep(5000);
        Assert.assertTrue(webDriver.findElement(POPUP_INFORMER).isDisplayed());
    }
}

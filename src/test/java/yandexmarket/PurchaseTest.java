package yandexmarket;

import Pages.BasePage;
import Pages.ProductCard;
import Pages.YandexMarketPage;

import org.testng.annotations.Test;

public class PurchaseTest extends BaseTest{



    @Test
    public void purchaseTest() throws InterruptedException {
//        Assert.assertTrue(webDriver.findElement(YANDEX_LOGO).isDisplayed());
//        Thread.sleep(5000);
        YandexMarketPage yandexMarketPage = new YandexMarketPage(webDriver);
        ProductCard productCard = new ProductCard(webDriver);
        yandexMarketPage.processCaptcha();
        yandexMarketPage.enterToProfile();
        yandexMarketPage.goToCatalog();
        yandexMarketPage.moveToLeftMenuItem("Зоотовары");
        yandexMarketPage.processCaptcha();
        yandexMarketPage.goToCatalogSection("Для собак", "Лакомства");
        yandexMarketPage.processCaptcha();
        yandexMarketPage.enterPrice("50", "5000");
        yandexMarketPage.selectDeliveryType("Доставка курьером");
        yandexMarketPage.selectManufacturer("Pedigree");
        yandexMarketPage.openFirstFoundProduct();
        productCard.compareProduct();
        Thread.sleep(10000);
    }

}

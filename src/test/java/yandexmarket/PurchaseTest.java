package yandexmarket;

import pages.ProductCard;
import pages.YandexMarketPage;

import org.testng.annotations.Test;

public class PurchaseTest extends BaseTest{

    @Test
    public void purchaseTest() throws InterruptedException {
        YandexMarketPage yandexMarketPage = new YandexMarketPage(webDriver);
        ProductCard productCard = new ProductCard(webDriver);
        yandexMarketPage.processCaptcha();
        yandexMarketPage.goToCatalog();
        yandexMarketPage.moveToLeftMenuItem("Зоотовары");
        yandexMarketPage.goToCatalogSection("Для кошек", "Лакомства");
        yandexMarketPage.enterPrice("50", "1500");
        yandexMarketPage.selectDeliveryType("Доставка курьером");
        yandexMarketPage.selectManufacturer("Мнямс");
        yandexMarketPage.openFirstFoundProduct();
        productCard.compareProduct();
    }

}

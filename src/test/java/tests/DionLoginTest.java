package tests;

import org.testng.annotations.Test;
import pages.DionGreetingPage;


public class DionLoginTest extends BaseTest{

    @Test
    public void loginTest() throws InterruptedException {
        DionGreetingPage dionGreetingPage = new DionGreetingPage(webDriver);
        dionGreetingPage.goToLogin();
        Thread.sleep(1000);
        dionGreetingPage.auth("user_at2@test.ru", "123456");
        Thread.sleep(1000);

    }

}

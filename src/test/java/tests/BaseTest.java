package tests;

import common.Constant;
import common.helpers.BrowserHelper;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;


public class BaseTest {
    @BeforeTest
    public void beforeTest() {
        System.out.println("Pre-condition");
        BrowserHelper.startBrowser(BrowserHelper.DriverType.CHROME);
        BrowserHelper.navigateToUrl(Constant.RAILWAY_URL);
    }

    @AfterTest
    public void afterTest() {
        System.out.println("Post-condition");
        BrowserHelper.quitBrowser();
    }
}

package tests;

import common.Constant;
import common.helpers.BrowserHelper;
import common.helpers.LogHelper;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


public class BaseTest {
    @BeforeMethod()
    public void beforeMethod() {
        LogHelper.info("Pre-condition");
        BrowserHelper.startBrowser(BrowserHelper.DriverType.CHROME);
        BrowserHelper.navigateToUrl(Constant.URL);
    }

    @AfterMethod
    public void afterMethod() {
        LogHelper.info("Post-condition");
        BrowserHelper.quitBrowser();
    }
}

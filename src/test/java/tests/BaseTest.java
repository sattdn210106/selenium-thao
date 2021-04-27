package tests;

import common.Constant;
import common.helpers.BrowserHelper;
import common.helpers.Log;
import org.apache.log4j.BasicConfigurator;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


public class BaseTest {
    @BeforeMethod()
    public void beforeTest() {
        BasicConfigurator.configure();
        Log.info("Pre-condition");
        BrowserHelper.startBrowser(BrowserHelper.DriverType.CHROME);
        BrowserHelper.navigateToUrl(Constant.RAILWAY_URL);
    }

    @AfterMethod
    public void afterMethod() {
        Log.info("Post-condition");
        BrowserHelper.quitBrowser();
    }
}

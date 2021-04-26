package tests;

import common.Constant;
import common.helpers.BrowserHelper;
import org.apache.log4j.BasicConfigurator;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;


public class BaseTest {
    @BeforeMethod()
    public void beforeTest() {
        BasicConfigurator.configure();
        System.out.println("Pre-condition");
        BrowserHelper.startBrowser(BrowserHelper.DriverType.CHROME);
        BrowserHelper.navigateToUrl(Constant.RAILWAY_URL);
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("Post-condition");
        BrowserHelper.quitBrowser();
    }
}

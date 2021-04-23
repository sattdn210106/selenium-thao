package common.helpers;

import common.Constant;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.concurrent.TimeUnit;

public class BrowserHelper {

    public enum DriverType {CHROME, FIREFOX, IE}

    public static void navigateToUrl(String url) {
        Constant.WEBDRIVER.get(url);
    }

    public static void startBrowser(DriverType driverType) {
        switch (driverType) {
            case CHROME:
                WebDriverManager.chromedriver().setup();
                Constant.WEBDRIVER = new ChromeDriver();
                break;
            case FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                Constant.WEBDRIVER = new FirefoxDriver();
                break;
            case IE:
                WebDriverManager.iedriver().setup();
                Constant.WEBDRIVER = new InternetExplorerDriver();
                break;
        }
        Constant.WEBDRIVER.manage().timeouts().implicitlyWait(Constant.WAIT_IMPLICITLY_TIME, TimeUnit.SECONDS);
        Constant.WEBDRIVER.manage().window().maximize();
    }

    public static void quitBrowser() {
        if (Constant.WEBDRIVER != null) {
            Constant.WEBDRIVER.quit();
            Constant.WEBDRIVER = null;
        }
    }
}

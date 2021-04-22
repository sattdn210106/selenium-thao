package common.helpers;

import common.constants.Constant;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserHepler {

    public enum DriverType {CHROME, FIREFOX, IE}

    public static void navigateToUrl(String url){
        Constant.WEBDRIVER.get(url);
    }

    public static void startBrowser (DriverType driverType) {
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
        Constant.WEBDRIVER.manage().window().maximize();
    }

    public static void quitBrowser() {
        if (Constant.WEBDRIVER != null) {
            Constant.WEBDRIVER.quit();
            Constant.WEBDRIVER = null;
        }
    }


}

package common.helpers;

import common.Constant;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class BrowserHelper {

    private static WebDriver driver;

    public enum DriverType {CHROME, FIREFOX, EDGE}

    public static void navigateToUrl(String url) {
        driver.get(url);
    }

    public static void startBrowser(DriverType driverType) {
        switch (driverType) {
            case CHROME:
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case EDGE:
                WebDriverManager.iedriver().setup();
                driver = new EdgeDriver();
                break;
        }
        driver.manage().timeouts().implicitlyWait(Constant.IMPLICIT_WAIT_TIME, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    public static void quitBrowser() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static String getPageTitle() {
        return BrowserHelper.getDriver().getTitle().trim();
    }

    public static void acceptAlert() {
        driver.switchTo().alert().accept();
    }

    public static void waitForAlert() {
        WebDriverWait wait = new WebDriverWait(driver, Constant.EXPLICIT_WAIT_TIME);
        wait.until(ExpectedConditions.alertIsPresent());
    }
}

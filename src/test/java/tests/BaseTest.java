package tests;

import common.constants.Constant;
import common.helpers.Helper;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;


public class BaseTest {
    @BeforeTest
    public void beforeTest() {
        System.out.println("Pre-condition");
        System.setProperty("webdriver.chrome.driver", Helper.getProjectPath() + "\\src\\main\\resources\\chromedriver.exe");
        Constant.WEBDRIVER = new ChromeDriver();
        Constant.WEBDRIVER.manage().window().maximize();
    }

    @AfterTest
    public void afterTest() {
        System.out.println("Post-condition");
        Constant.WEBDRIVER.quit();
    }
}

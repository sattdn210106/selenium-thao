package common.helpers;

import common.constants.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementHelper {
    public static void waitElementExist(By locator, int seconds) {
        WebDriverWait wait = new WebDriverWait(Constant.WEBDRIVER, seconds);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }


}

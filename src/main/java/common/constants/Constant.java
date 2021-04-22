package common.constants;

import common.helpers.Helper;
import org.openqa.selenium.WebDriver;

public class Constant {
    //Common
    public static WebDriver WEBDRIVER;
    public static final String RAILWAY_URL = "http://www.railwayqa.somee.com/";
    public static final String USERNAME = "dangthao@gmail.com";
    public static final String PASSWORD = "123456789";
    public static final int WAIT_ELEMENT_TIME = 5;
    public static final String JSON_PATH = Helper.getProjectPath() + "\\src\\test\\resources\\input\\";

    //Book ticket
    public static final String DEPART_DATE = "";
}

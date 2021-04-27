package common;

import common.helpers.Common;
import org.openqa.selenium.WebDriver;

public class Constant {
    //Common
    public static final String RAILWAY_URL = "http://www.railway2.somee.com/";
    public static final String USERNAME = "dangthao@gmail.com";
    public static final String PASSWORD = "123456789";
    public static final int WAIT_ELEMENT_TIME = 5;
    public static final int WAIT_IMPLICITLY_TIME = 20;
    public static final String JSON_PATH = "src\\test\\resources\\input\\";

    //Book ticket
    public static final String DEPART_DATE = Common.plusDayFromNow(5);
    public static final String DEPART_FROM = "Sài Gòn";
    public static final String ARRIVE_AT = "Nha Trang";
    public static final String SEAT_TYPE = "Soft seat";
    public static final String TICKET_AMOUNT = "1";
}

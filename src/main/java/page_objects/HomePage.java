package page_objects;

import common.constants.Constant;

public class HomePage extends BasePage{
    //Locators
    //Elements
    //Methods

    public void open() {
        Constant.WEBDRIVER.navigate().to(Constant.RAILWAY_URL);
    }
}

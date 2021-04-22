package tests;

import common.constants.Constant;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page_objects.BookTicketPage;
import page_objects.HomePage;
import page_objects.LoginPage;

public class BookTicketTest extends BaseTest{
    LoginPage loginPage = new LoginPage();
    BookTicketPage bookTicketPage = new BookTicketPage();

    @BeforeMethod
    public void beforeMethod() {
        homePage.gotoLoginPage();
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);
        homePage.gotoBookTicketPage();
    }

    @AfterMethod
    public void afterMethod() {
        if (homePage.doesTabLogoutExist()) {
            homePage.logout();
        }
    }

    @Test
    public void TC001() {
        System.out.println("TC001: User can book a ticket");
    }
}

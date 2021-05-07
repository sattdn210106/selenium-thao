package page_objects;

import common.helpers.BrowserHelper;
import common.helpers.ElementHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TrainTimetablePage extends BasePage {

    //Dynamic xpath
    String dynamicLnkBookTicket = "//td[count(//th[text()='Depart Station']/preceding-sibling::th)+1][text()='%s']" +
            "//parent::tr//td[count(//th[text()='Arrive Station']/preceding-sibling::th)+1][text()='%s']" +
            "//parent::tr//a[text()='book ticket']";

    //Locator
    private final By tblTrainTime = By.className("MyTable");

    //Elements
    private WebElement getTblTrainTime() {
        return BrowserHelper.getDriver().findElement(tblTrainTime);
    }

    private WebElement getLnkBookTicket(String departStation, String arriveStation) {
        return getTblTrainTime().findElement(By.xpath(String.format(dynamicLnkBookTicket, departStation, arriveStation)));
    }

    //Method
    public void clickBookTicketLnk(String departStation, String arriveStation) {
        ElementHelper.scrollToView(getLnkBookTicket(departStation, arriveStation));
        getLnkBookTicket(departStation, arriveStation).click();
    }
}

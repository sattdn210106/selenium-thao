package models;

import common.Common;
import common.Constant;

import java.time.LocalDate;

public class Ticket {
    private String departDate;
    private String departFrom;
    private String arriveAt;
    private String seatType;
    private String ticketAmount;
    private String ticketPrice;
    private String bookDate;
    private String expiredDate;

    public Ticket() {
    }

    public Ticket(String departDate, String departFrom, String arriveAt, String seatType, String ticketAmount, String ticketPrice) {
        this.departDate = departDate;
        this.departFrom = departFrom;
        this.arriveAt = arriveAt;
        this.seatType = seatType;
        this.ticketAmount = ticketAmount;
        this.ticketPrice = ticketPrice;
        setBookDate();
        setExpiredDate();
    }

    public String getArriveAt() {
        return arriveAt;
    }

    public String getDepartDate() {
        return departDate;
    }

    public String getDepartFrom() {
        return departFrom;
    }

    public String getSeatType() {
        return seatType;
    }

    public String getTicketAmount() {
        return ticketAmount;
    }

    public String getTicketPrice() {
        return ticketPrice;
    }

    public String getBookDate() {
        return bookDate;
    }

    public String getExpiredDate() {
        return expiredDate;
    }

    public void setTicketPrice(String ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public void setArriveAt(String arriveAt) {
        this.arriveAt = arriveAt;
    }

    public void setDepartDate(String departDate) {
        this.departDate = departDate;
    }

    public void setDepartFrom(String departFrom) {
        this.departFrom = departFrom;
    }

    public void setSeatType(String seatType) {
        this.seatType = seatType;
    }

    public void setTicketAmount(String ticketAmount) {
        this.ticketAmount = ticketAmount;
    }

    public void setBookDate() {
        this.bookDate = Common.changeDateFormat(LocalDate.now().toString(), Constant.DATE_FORMAT);
    }

    public void setExpiredDate() {
        this.expiredDate = Common.plusDayFromNow(3, Constant.DATE_FORMAT);
    }

    public void setBookDate(String bookDate) {
        this.bookDate = bookDate;
    }

    public void setExpiredDate(String expiredDate) {
        this.expiredDate = expiredDate;
    }
}

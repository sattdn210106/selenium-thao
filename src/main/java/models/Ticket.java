package models;

import common.Constant;
import common.Common;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Ticket {
    private String departDate;
    private String departFrom;
    private String arriveAt;
    private String seatType;
    private String ticketAmount;
    private String ticketPrice;

    public Ticket(String departDate, String departFrom, String arriveAt, String seatType, String ticketAmount, String ticketPrice) {
        setArriveAt(arriveAt);
        setTicketAmount(ticketAmount);
        setDepartDate(departDate);
        setDepartFrom(departFrom);
        setSeatType(seatType);
        setTicketPrice(ticketPrice);
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
        return Common.changeFormatDate(LocalDate.now().toString(), Constant.FORMAT_DATE);
    }

    public String getExpiredDate() {
        return Common.plusDayFromNow(3, Constant.FORMAT_DATE);
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

    public Map<String, String> getInformationTicket() {
        Map<String, String> ticketInformation = new HashMap<>();
        ticketInformation.put(Constant.HEADER_OF_TABLE[0], departFrom);
        ticketInformation.put(Constant.HEADER_OF_TABLE[1], arriveAt);
        ticketInformation.put(Constant.HEADER_OF_TABLE[2], seatType);
        ticketInformation.put(Constant.HEADER_OF_TABLE[3], departDate);
        ticketInformation.put(Constant.HEADER_OF_TABLE[4], getBookDate());
        ticketInformation.put(Constant.HEADER_OF_TABLE[5], getExpiredDate());
        ticketInformation.put(Constant.HEADER_OF_TABLE[6], ticketAmount);
        ticketInformation.put(Constant.HEADER_OF_TABLE[7], ticketPrice);
        return ticketInformation;
    }
}

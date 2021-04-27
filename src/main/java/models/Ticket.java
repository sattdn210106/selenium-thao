package models;

public class Ticket {
    private String departDate;
    private String departFrom;
    private String arriveAt;
    private String seatType;
    private String ticketAmount;

    public Ticket(String departDate, String departFrom, String arriveAt, String seatType, String ticketAmount) {
        setArriveAt(arriveAt);
        setTicketAmount(ticketAmount);
        setDepartDate(departDate);
        setDepartFrom(departFrom);
        setSeatType(seatType);
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
}

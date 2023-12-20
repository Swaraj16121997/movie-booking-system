package models;

import java.util.List;

public class Ticket extends BaseModel{
    private User user;
    private List<ShowSeat> showSeats;
    private TicketStatus ticketStatus;
    private double totalAmount;
    private List<Payment> payments;         // suppose 1st two or three payment attempts failed then we'll be having the track/history of it
}

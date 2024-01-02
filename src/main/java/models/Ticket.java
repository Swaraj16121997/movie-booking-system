package models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Ticket extends BaseModel{
    @ManyToOne
    private User user;
    @ManyToMany
    private List<ShowSeat> showSeats;
    @Enumerated(EnumType.ORDINAL)
    private TicketStatus ticketStatus;
    private double totalAmount;
    @OneToMany
    private List<Payment> payments;         // suppose 1st two or three payment attempts failed then we'll be having the track/history of it
}

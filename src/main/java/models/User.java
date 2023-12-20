package models;

import org.apache.logging.log4j.message.StringFormattedMessage;

import java.util.List;

public class User extends BaseModel{
    private String username;
    private String password;
    private String emailId;
    private List<Ticket> ticketBookings;
}

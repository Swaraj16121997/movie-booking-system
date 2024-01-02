package models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
import org.apache.logging.log4j.message.StringFormattedMessage;

import java.util.List;

@Getter
@Setter
@Entity
public class User extends BaseModel{
    private String username;
    private String password;
    private String emailId;
    @OneToMany
    private List<Ticket> ticketBookings;
}

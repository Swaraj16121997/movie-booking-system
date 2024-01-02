package dtos;

import lombok.Getter;
import lombok.Setter;
import models.ResponseStatus;

@Getter
@Setter
public class TicketResponseDto {
    private Long ticketId;
    private double amount;
    private ResponseStatus responseStatus;
}

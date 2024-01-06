package com.example.showbookingsystem.dtos;

import com.example.showbookingsystem.models.ResponseStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TicketResponseDto {
    private Long ticketId;
    private double amount;
    private ResponseStatus responseStatus;
}

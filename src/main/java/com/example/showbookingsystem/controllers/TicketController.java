package com.example.showbookingsystem.controllers;

import com.example.showbookingsystem.dtos.TicketRequestDto;
import com.example.showbookingsystem.exceptions.ShowNotFoundException;
import com.example.showbookingsystem.exceptions.ShowSeatNotAvailableException;
import com.example.showbookingsystem.exceptions.UserNotFoundException;
import com.example.showbookingsystem.models.ResponseStatus;
import com.example.showbookingsystem.models.Ticket;
import com.example.showbookingsystem.services.TicketService;
import com.example.showbookingsystem.dtos.TicketResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class TicketController { // waiter
    private TicketService ticketService;

    @Autowired
    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }
    public TicketResponseDto bookTickets(TicketRequestDto ticketRequestDto) throws UserNotFoundException, ShowNotFoundException, ShowSeatNotAvailableException {
        TicketResponseDto response = new TicketResponseDto();

        try {
            Ticket ticket = ticketService.bookMovie(ticketRequestDto.getUserId(), ticketRequestDto.getShowId(), ticketRequestDto.getShowSeatIds());

            response.setTicketId(ticket.getId());
            response.setResponseStatus(ResponseStatus.CONFIRMED);
            response.setAmount(ticket.getTotalAmount());
        } catch (RuntimeException runtimeException) {
            response.setResponseStatus(ResponseStatus.NOT_CONFIRMED);
        }

        return response;
    }

    public TicketResponseDto cancelMovie() {
        // TODO: implementation of ticket cancellation
        return null;
    }
}

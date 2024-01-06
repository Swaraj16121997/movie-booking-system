package com.example.showbookingsystem.services;
import com.example.showbookingsystem.repositories.ShowSeatTypeRepository;
import com.example.showbookingsystem.models.ShowSeatType;
import org.springframework.stereotype.Service;

import com.example.showbookingsystem.models.Show;
import com.example.showbookingsystem.models.ShowSeat;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class PriceCalculatorService {
    private ShowSeatTypeRepository showSeatTypeRepository;
    @Autowired
    public PriceCalculatorService(ShowSeatTypeRepository showSeatTypeRepository) {
        this.showSeatTypeRepository = showSeatTypeRepository;
    }
    public double calculateTicketPrice(List<ShowSeat> showSeats, Show show) {
        double amount = 0;

        List<ShowSeatType> showSeatTypes = showSeatTypeRepository.findAllById(show.getId());

        for (ShowSeat showSeat : showSeats) {
            for (ShowSeatType showSeatType : showSeatTypes) {
                if (showSeat.getSeat().getSeatType().equals(showSeatType.getSeatType())) {
                    amount += showSeatType.getPrice();
                }
            }
            // Inner for loop can be removed if we use a HashMap of ShowSeatType and Price.
        }

        return amount;
    }
}
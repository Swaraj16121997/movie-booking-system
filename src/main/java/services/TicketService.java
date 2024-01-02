package services;

import exceptions.ShowNotFoundException;
import exceptions.ShowSeatNotAvailableException;
import exceptions.UserNotFoundException;
import models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import repositories.ShowRepository;
import repositories.ShowSeatRepository;
import repositories.TicketRepository;
import repositories.UserRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class TicketService {
    private UserRepository userRepository;
    private ShowRepository showRepository;
    private ShowSeatRepository showSeatRepository;
    private TicketRepository ticketRepository;
    private PriceCalculatorService priceCalculatorService;

    @Autowired
    public TicketService(UserRepository userRepository,
                         ShowRepository showRepository,
                         ShowSeatRepository showSeatRepository,
                         TicketRepository bookingRepository,
                         PriceCalculatorService priceCalculatorService) {
        this.userRepository = userRepository;
        this.showRepository = showRepository;
        this.showSeatRepository = showSeatRepository;
        this.ticketRepository = bookingRepository;
        this.priceCalculatorService = priceCalculatorService;
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public Ticket bookMovie(Long userId, Long showId, List<Long> showSeatIds) throws UserNotFoundException, ShowNotFoundException, ShowSeatNotAvailableException {
        /*
            Steps :- (Reference : Approach#1 from notes.)
            -------------TAKE A LOCK----------------
            1. Get the user from userId.
            2. Get the show from showId.
            3. Get the list of showSeats from showSeatIds.
            4. Check if all the show seats are available.
            5. If all the show seats are not available then throw an exception.
            6. If all are available, then change the status to be LOCKED.
            7. Change the status in DB as well.
            8. Create the Booking Object, and store it in DB.
            9. Return the Booking Object.
            -----------RELEASE THE LOCK---------------
         */
        //1. Get the user from userId.
        Optional<User> optionalUser = userRepository.findById(userId);
        if (optionalUser.isEmpty()) {
            throw new UserNotFoundException("Invalid userId");
        }
        User bookedBy = optionalUser.get();

        //2. Get the show from showId.
        Optional<Show> optionalShow = showRepository.findById(showId);
        if (optionalShow.isEmpty()) {
            throw new ShowNotFoundException("Invalid showId");
        }
        Show show = optionalShow.get();

        //3. Get the list of showSeats from showSeatIds.
        List<ShowSeat> showSeats = showSeatRepository.findAllById(showSeatIds);
        //4. Check if all the show seats are available.
        for (ShowSeat showSeat : showSeats) {
            if (!showSeat.getShowSeatStatus().equals(ShowSeatStatus.AVAILABLE)) {
                //5. If all the show seats are not available then throw an exception.
                throw new ShowSeatNotAvailableException("ShowSeat with id: " + showSeat.getId() + " isn't available.");
            }
        }

        List<ShowSeat> bookedShowSeats = new ArrayList<>();
        //6. If all are available, then change the status to be LOCKED.
        for (ShowSeat showSeat : showSeats) {
            showSeat.setShowSeatStatus(ShowSeatStatus.BLOCKED);
            //7. Change the status in DB as well.
            bookedShowSeats.add(showSeatRepository.save(showSeat));
        }

        //8. Create the Booking Object, and store it in DB.
        Ticket ticket = new Ticket();
        ticket.setUser(bookedBy);
        ticket.setTicketStatus(TicketStatus.IN_PROGRESS);
        ticket.setPayments(new ArrayList<>());
        ticket.setShowSeats(bookedShowSeats);
        ticket.setCreatedAt(new LocalDate());
        ticket.setUpdatedAt(new LocalDate());
        ticket.setTotalAmount(priceCalculatorService.calculateBookingPrice(bookedShowSeats, show));

        return ticketRepository.save(ticket);
        // ------LOCK WILL BE RELEASED------
    }
}

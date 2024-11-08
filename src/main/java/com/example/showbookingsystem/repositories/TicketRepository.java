package com.example.showbookingsystem.repositories;

import com.example.showbookingsystem.models.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends JpaRepository<Ticket,Long> {
    @Override
    Ticket save(Ticket ticket);
}

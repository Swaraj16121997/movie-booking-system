package com.example.showbookingsystem.repositories;

import com.example.showbookingsystem.models.ShowSeatType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShowSeatTypeRepository extends JpaRepository<ShowSeatType,Long> {
    List<ShowSeatType> findAllById(Long showSeatTypeId);
}

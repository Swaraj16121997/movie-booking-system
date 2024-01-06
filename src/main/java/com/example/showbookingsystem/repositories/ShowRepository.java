package com.example.showbookingsystem.repositories;

import com.example.showbookingsystem.models.Show;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ShowRepository extends JpaRepository<Show, Long> { // JpaRepository<DataType of Object you want to get, DataType of Object you need to pass>
    @Override
    Optional<Show> findById(Long showId);
}

package com.example.showbookingsystem.repositories;

import com.example.showbookingsystem.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    //JPARepository -> Inbuilt support for all type of SQL queries.
    @Override
    Optional<User> findById(Long userId);

    @Override
    User save(User user);

    Optional<User> findByEmailId(String email);
    //select * from users where email = <input_email>

    // Optional<User> findByUsername(String userName);
    //select * from users where username = <input>
}
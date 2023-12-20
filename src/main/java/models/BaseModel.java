package models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;


@Getter
@Setter
@MappedSuperclass          // tells JPA that, all the attributes of the base/super class, should also be mapped along with the attributes of its child class, everytime when JPA will create the table for its child class
public class BaseModel {
    @Id                 // primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // pattern of storing Id(s) like even, odd, etc.
    private Long id;
    private LocalDate createdAt;
    private LocalDate updatedAt;
}

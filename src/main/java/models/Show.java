package models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity(name = "shows") // Show is a reserved keyword in MySQL. @Entity is used for creating table with the class name in the database
public class Show extends BaseModel{
    @ManyToOne
    private Movie movie;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    @ManyToOne
    private Screen screen;
    @Enumerated(EnumType.ORDINAL)
    @ElementCollection
    private List<Feature> features;
}

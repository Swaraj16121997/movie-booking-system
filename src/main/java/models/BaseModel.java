package models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
public class BaseModel {
    @Id
    private Long id;
    private LocalDate createdAt;
    private LocalDate updatedAt;
}

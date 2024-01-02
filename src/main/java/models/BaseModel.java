package models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.data.jpa.repository.config.AuditingBeanDefinitionParser;

import java.time.LocalDate;


@Getter
@Setter
@MappedSuperclass          // tells JPA that, all the attributes of the base/super class, should also be mapped along with the attributes of its child class, everytime when JPA will create the table for its child class
@EntityListeners(AuditingEntityListener.class)
public class BaseModel {
    @Id                 // primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // pattern of storing Id(s) like even, odd, etc.
    private Long id;
    @CreatedDate
    private LocalDate createdAt;
    @LastModifiedDate
    private LocalDate updatedAt;
}

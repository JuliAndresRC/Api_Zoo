package co.edu.icesi.apizoo.model;

import lombok.*;
import org.aspectj.lang.annotation.Before;
import org.hibernate.annotations.Type;
import org.springframework.context.annotation.Bean;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Table
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Animal {

    @Id
    @Type(type="org.hibernate.type.UUIDCharType")
    private UUID id;

    @Size(max = 120, message = "The name can only be up to 120 characters including spaces.")
    private String name;

    private String sex;

    @Min(value = 50, message = "Weight must be greater than or equal to 50")
    @Max(value = 140, message = "Weight must be less than or equal to 140")
    private Integer weight;

    @Max(value = 20, message = "Age should be less than or equal to 20")
    private Integer age;

    @Min(value = 53, message = "Weight must be greater than or equal to 53 cm")
    @Max(value = 120, message = "Weight must be less than or equal to 120 cm")
    private Integer height;


    private LocalDateTime arrivalDate;

    private UUID father;

    private UUID mother;


    @PrePersist
    public void generateId(){
        this.id = UUID.randomUUID();
    }
}

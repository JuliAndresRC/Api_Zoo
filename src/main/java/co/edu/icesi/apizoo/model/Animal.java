package co.edu.icesi.apizoo.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Table(name = "animal")
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String name;
    private String sex;
    private Double weight;
    private String age;
    private Double height;
    private LocalDateTime arrivalDate;

    @ManyToOne
    @JoinColumn(name = "father_id")
    private Animal father;
    @ManyToOne
    @JoinColumn(name = "mother_id")
    private Animal mother;
}

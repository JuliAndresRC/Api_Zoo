package co.edu.icesi.apizoo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnimalDTO {

    private UUID id;
    private String Name;
    private String Sex;
    private Double Weight;
    private Integer Age;
    private Double Height;
    private LocalDateTime ArrivalDate;
    private UUID FatherID;
    private UUID MotherID;
}

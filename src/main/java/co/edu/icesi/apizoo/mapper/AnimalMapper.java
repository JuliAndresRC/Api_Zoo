package co.edu.icesi.apizoo.mapper;

import co.edu.icesi.apizoo.dto.AnimalDTO;
import co.edu.icesi.apizoo.model.Animal;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AnimalMapper {
    Animal toAnimal(AnimalDTO animalDTO);
    AnimalDTO toAnimalDTO(Animal animal);
}
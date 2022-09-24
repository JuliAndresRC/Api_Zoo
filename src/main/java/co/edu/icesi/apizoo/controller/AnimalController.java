package co.edu.icesi.apizoo.controller;

import co.edu.icesi.apizoo.api.AnimalAPI;
import co.edu.icesi.apizoo.dto.AnimalDTO;
import co.edu.icesi.apizoo.mapper.AnimalMapper;
import co.edu.icesi.apizoo.root.exception.CaliZooApiError;
import co.edu.icesi.apizoo.root.exception.CaliZooApiException;
import co.edu.icesi.apizoo.service.AnimalService;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class AnimalController implements AnimalAPI {

    private AnimalService animalService;
    private AnimalMapper animalMapper;

    @Override
    public AnimalDTO getAnimal(UUID animalID) {
        return animalMapper.fromAnimal(animalService.getAnimal(animalID));
    }

    @Override
    public List<AnimalDTO> getAnimals() {
        return animalService.getAnimals().stream().map(animalMapper::fromAnimal).collect(Collectors.toList());
    }

    @Override
    public AnimalDTO createAnimal(AnimalDTO animalDTO) {
        if (validateLengthName(animalDTO.getName()) && !validateUniqueName(animalDTO.getName()) && validateDate(animalDTO.getArrivalDate())){
            return animalMapper.fromAnimal(animalService.createAnimal(animalMapper.fromDTO(animalDTO)));
        }else{
            return null;
        }
    }

    private boolean validateDate(LocalDateTime arrivalDate) {
        return true;
    }

    private boolean validateUniqueName(String name) {
        return false;
    }

    private boolean validateLengthName(String name) {
        if(name.length() <= 120 && name.matches("^\\s+[0-9a-zA-z]*$")){
            return true;
        }else{
            throw new CaliZooApiException(HttpStatus.NOT_ACCEPTABLE, new CaliZooApiError("406", "Invalid name: Can be up to 120 digits long."));
        }
    }

    @Override
    public AnimalDTO updateAnimal(UUID animalID) {
        return null;
    }

    @Override
    public void deleteAnimal(UUID animalID) {

    }
}

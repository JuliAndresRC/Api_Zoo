package co.edu.icesi.apizoo.controller;

import co.edu.icesi.apizoo.api.AnimalAPI;
import co.edu.icesi.apizoo.dto.AnimalDTO;
import co.edu.icesi.apizoo.mapper.AnimalMapper;
import co.edu.icesi.apizoo.service.AnimalService;

import java.util.List;
import java.util.UUID;

public class AnimalController implements AnimalAPI {

    private AnimalService animalService;
    private AnimalMapper animalMapper;

    @Override
    public AnimalDTO getAnimal(UUID animalID) {
        return null;
    }

    @Override
    public List<AnimalDTO> getAnimals() {
        return null;
    }

    @Override
    public AnimalDTO createAnimal(AnimalDTO animalDTO) {
        return null;
    }

    @Override
    public AnimalDTO updateAnimal(UUID animalID) {
        return null;
    }

    @Override
    public void deleteAnimal(UUID animalID) {

    }
}

package co.edu.icesi.apizoo.controller;

import co.edu.icesi.apizoo.api.AnimalAPI;
import co.edu.icesi.apizoo.dto.AnimalDTO;
import co.edu.icesi.apizoo.mapper.AnimalMapper;
import co.edu.icesi.apizoo.model.Animal;
import co.edu.icesi.apizoo.service.AnimalService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
public class AnimalController implements AnimalAPI {

    private AnimalService animalService;
    private AnimalMapper animalMapper;

    @Override
    public AnimalDTO getAnimalById(UUID animalID) {
        return animalMapper.toAnimalDTO(animalService.getAnimalById(animalID));
    }

    @Override
    public List<AnimalDTO> getAnimals() {
        return animalService.getAnimals().stream().map(animalMapper::toAnimalDTO).collect(Collectors.toList());
    }

    @Override
    public AnimalDTO createAnimal(AnimalDTO animalDTO) {
        if(validateName(animalDTO.getName()) && validUniqueName(animalDTO.getName())){
            return animalMapper.toAnimalDTO(animalService.createAnimal(animalMapper.toAnimal(animalDTO)));
        }else{
            return null;
        }
    }

    private boolean validateName(String name) {
        Pattern range = Pattern.compile("[^A-Za-z ]");
        Matcher validName = range.matcher(name);
        if(!validName.find()){
            return true;
        }else {
            throw new RuntimeException("The name can only have letters and spaces");
        }
    }

    private boolean validUniqueName(String name) {
        boolean result = true;
        List<AnimalDTO> animals = getAnimals();
        for (AnimalDTO animalDTO : animals){
            if(animalDTO.getName().equalsIgnoreCase(name)){
                result = false;
                throw new RuntimeException("The name must be unique");
            }
        }
        return result;
    }

    @Override
    public AnimalDTO updateAnimal(AnimalDTO animalDTO) {
        List<AnimalDTO> animals = getAnimals();
        AnimalDTO animalAux = null;
        for(AnimalDTO animal : animals){
            if(animal.getName().equalsIgnoreCase(animalDTO.getName())){
                animal = animalDTO;
                animalAux = animal;
            }
        }
        return animalMapper.toAnimalDTO(animalService.updateAnimal(animalMapper.toAnimal(animalAux)));
    }
}

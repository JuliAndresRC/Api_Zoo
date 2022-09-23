package co.edu.icesi.apizoo.service.impl;

import co.edu.icesi.apizoo.model.Animal;
import co.edu.icesi.apizoo.repository.AnimalRepository;
import co.edu.icesi.apizoo.service.AnimalService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class AnimalServiceImpl implements AnimalService {

    private AnimalRepository animalRepository;

    @Override
    public Animal getAnimal(UUID animalID) {
        return animalRepository.findById(animalID).orElse(null);
    }

    @Override
    public List<Animal> getAnimals() {
        return StreamSupport.stream(animalRepository.findAll().spliterator(), false).collect(Collectors.toList());
    }

    @Override
    public Animal createAnimal(Animal animal) {
        return animalRepository.save(animal);
    }

    @Override
    public Animal updateAnimal(Animal animal) {
        Optional<Animal> aux = animalRepository.findById(animal.getId());

        if(aux.isPresent()) {
            return animalRepository.save(animal);
        }else {
            return null;
        }
    }

    @Override
    public void deleteAnimal(UUID animalID) {
        animalRepository.deleteById(animalID);
    }
}

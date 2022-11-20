package co.edu.icesi.apizoo.controller;

import co.edu.icesi.apizoo.api.AnimalAPI;
import co.edu.icesi.apizoo.api.ViewControl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
public class ViewController  implements ViewControl {

    @Autowired
    private AnimalAPI animalAPI;

    @Override
    public String zoo() {
        return "zoo";
    }

    @Override
    public String getAnimals(){
        return "animals-index";
    }

    @Override
    public String addAnimal() {
        return "create-animal";
    }

    @Override
    public String createAnimal() {
        return "redirect:/animals/index";
    }

    @Override
    public String editAnimal() {
        return "update-animal";
    }

    @Override
    public String updateAnimal() {
        return "redirect:/animals/index";
    }

}

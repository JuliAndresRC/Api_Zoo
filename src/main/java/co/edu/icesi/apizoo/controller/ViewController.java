package co.edu.icesi.apizoo.controller;

import co.edu.icesi.apizoo.api.AnimalAPI;
import co.edu.icesi.apizoo.api.ViewControl;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
public class ViewController  implements ViewControl {

    private AnimalAPI animalAPI;

    @GetMapping("/animals")
    public String zoo(){
        return "animals/zoo";
    }
}

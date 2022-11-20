package co.edu.icesi.apizoo.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/animals")
public interface ViewControl {

    @GetMapping
    public String zoo();

    @GetMapping("/index")
    public String getAnimals();

    @GetMapping("/add")
    public String addAnimal();

    @PostMapping("/create")
    public String createAnimal();

    @GetMapping("/edit")
    public String editAnimal();

    @PostMapping("/update")
    public String updateAnimal();
}

package com.workintech.fswebs17d1.controller;

import com.workintech.fswebs17d1.entity.Animal;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/workintech/animal")
public class AnimalController {

    Map<Integer, Animal> animals = new HashMap<Integer, Animal>();

    @GetMapping()
    public List<Animal> get(){
        return animals.values().stream().toList();
    }

    @GetMapping("/{id}")
    public Animal get(@PathVariable int id){
        return animals.get(id);
    }

    @PostMapping()
    public Animal post(@RequestBody Animal animal){
        animals.put(animal.getId(), animal);
        return animal;
    }

    @PutMapping("/{id}")
    public Animal put(@PathVariable int id, @RequestBody Animal animal){
        animals.put(id,animal);
        return animal;
    }

    @DeleteMapping("/{id}")
    public Animal delete(@PathVariable int id){
        Animal animal = animals.get(id);
        animals.remove(id);
        return animal;
    }

}

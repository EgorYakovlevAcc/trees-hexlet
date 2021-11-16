package ru.hexlet.lections.trees.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.hexlet.lections.trees.dto.PersonDto;
import ru.hexlet.lections.trees.dto.ShortPersonDto;
import ru.hexlet.lections.trees.model.Person;
import ru.hexlet.lections.trees.service.PersonService;

@RestController
@RequestMapping("/v1.0/people")
public class PersonController {
    private PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/short/{id}/")
    public ShortPersonDto getShortPersonById(@PathVariable("id") Long id) {
        return this.personService.getShortPersonDtoById(id);
    }

    @GetMapping("/{id}/")
    public PersonDto getPersonById(@PathVariable("id") Long id) {
        return this.personService.getPersonDtoById(id);
    }

    @PostMapping("/")
    public Person createPerson(@RequestBody ShortPersonDto shortPersonDto) {
        return this.personService.save(shortPersonDto);
    }
}

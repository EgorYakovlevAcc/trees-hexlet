package ru.hexlet.lections.trees.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.hexlet.lections.trees.repository.PersonRepository;
import ru.hexlet.lections.trees.service.PersonService;
import ru.hexlet.lections.trees.service.impl.PersonServiceImpl;

@Configuration
public class TreesAppConfig {
    @Bean
    public PersonService personService(PersonRepository personRepository) {
        return new PersonServiceImpl(personRepository);
    }
}

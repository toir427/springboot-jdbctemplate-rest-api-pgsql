package com.example.demo.api;

import com.example.demo.model.Person;
import com.example.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * @author toir427
 * @link http://tuychiev.com
 * @since 11/26/21
 */
@RequestMapping("api/v1/person")
@RestController
public class PersonController {
    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    public int create(@Validated @NonNull @RequestBody Person person) {
        return personService.create(person);
    }

    @GetMapping
    public List<Person> findAll() {
        return personService.findAll();
    }

    @GetMapping(path = "{id}")
    public Person findById(@PathVariable("id") UUID id) {
        return personService.findById(id);
    }

    @DeleteMapping(path = "{id}")
    public int deleteById(@PathVariable("id") UUID id) {
        return personService.deleteById(id);
    }

    @PutMapping(path = "{id}")
    public int updateById(@PathVariable("id") UUID id, @Validated @NonNull @RequestBody Person person) {
        return personService.updateById(id, person);
    }
}

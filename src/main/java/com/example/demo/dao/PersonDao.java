package com.example.demo.dao;

import com.example.demo.model.Person;

import java.util.List;
import java.util.UUID;

/**
 * @author toir427
 * @link http://tuychiev.com
 * @since 11/26/21
 */
public interface PersonDao {
    int create(UUID id, Person person);

    default int create(Person person) {
        UUID id = UUID.randomUUID();
        return create(id, person);
    }

    List<Person> findAll();

    Person findById(UUID id);

    int deleteById(UUID id);

    int updateById(UUID id, Person person);
}

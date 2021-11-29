package com.example.demo.service;

import com.example.demo.dao.PersonDao;
import com.example.demo.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * @author toir427
 * @link http://tuychiev.com
 * @since 11/26/21
 */
@Service
public class PersonService {

    private final PersonDao personDao;

    @Autowired
    public PersonService(@Qualifier("postgres") PersonDao personDao) {
        this.personDao = personDao;
    }

    public int create(Person person) {
        return personDao.create(person);
    }

    public List<Person> findAll() {
        return personDao.findAll();
    }

    public Person findById(UUID id) {
        return personDao.findById(id);
    }

    public int deleteById(UUID id) {
        return personDao.deleteById(id);
    }

    public int updateById(UUID id, Person newPerson) {
        return personDao.updateById(id, newPerson);
    }
}

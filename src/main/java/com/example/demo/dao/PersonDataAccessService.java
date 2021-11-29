package com.example.demo.dao;

import com.example.demo.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

/**
 * @author toir427
 * @link http://tuychiev.com
 * @since 11/26/21
 */
@Repository("postgres")
public class PersonDataAccessService implements PersonDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PersonDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int create(UUID id, Person person) {
        return jdbcTemplate.update("INSERT INTO person (id, name) VALUES (uuid_generate_v4(), ?)", person.getName());
    }

    @Override
    public List<Person> findAll() {
        return jdbcTemplate.query("SELECT id, name FROM person", new BeanPropertyRowMapper<Person>(Person.class));
    }

    @Override
    public Person findById(UUID id) {
        return jdbcTemplate.queryForObject("SELECT id, name FROM person WHERE id = ?", new BeanPropertyRowMapper<Person>(Person.class), id);
    }

    @Override
    public int deleteById(UUID id) {
        return jdbcTemplate.update("DELETE FROM person WHERE id=?", id);
    }

    @Override
    public int updateById(UUID id, Person person) {
        return jdbcTemplate.update("UPDATE person SET name = ? WHERE id = ?", person.getName(), id);
    }
}

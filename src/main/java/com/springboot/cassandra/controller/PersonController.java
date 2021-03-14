package com.springboot.cassandra.controller;

import com.springboot.cassandra.error.ResourceNotFoundException;
import com.springboot.cassandra.model.Person;
import com.springboot.cassandra.service.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class PersonController {

    private final Logger LOG = LoggerFactory.getLogger(getClass());

    @Autowired
    PersonService personService;

    @GetMapping("/persons")
    public List<Person> getPersons(){
        LOG.info("Getting all persons");
        return personService.allPersons();
    }

    @PostMapping("/persons/save")
    public Person addPerson(@RequestBody Person person) throws ParseException {
        LOG.info("Saving Person");
        personService.savePerson(person);
        LOG.info("Saved Person : " + person);
        return person;
    }

    @GetMapping("/persons/{id}")
    public Person findById(@PathVariable("id") String personId){
        LOG.info("Finding By Person Id");
        Person person = personService.findPersonById(personId).orElseThrow(
                () -> new ResourceNotFoundException("Person not found... by Id : " +personId));
        LOG.info("Found By Person Id : " + person);
        return person;
    }

    @PutMapping("/persons/{id}")
    public Person updateStudent(@PathVariable(value="id") String personId, @RequestBody Person personDetatils){
        LOG.info("Updating By Person Id");
        personService.updatePerson(personId,personDetatils);
        LOG.info("Updated By Person Id : " + personDetatils);
        return personDetatils;
    }

    @DeleteMapping("/persons/{id}")
    public void deleteStudent(@PathVariable(value="id") String personId) {
        LOG.info("Deleting By Person Id");
        personService.deletePerson(personId);
        LOG.info("Deleted By Person Id : " + personId);
    }

}

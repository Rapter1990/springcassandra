package com.springboot.cassandra.service;

import com.springboot.cassandra.model.Person;
import com.springboot.cassandra.repository.PersonRepository;
import com.springboot.cassandra.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PersonService {

   @Autowired
   PersonRepository personRepository;


   public Person savePerson(Person person) throws ParseException {

       LocalDate now = Utils.formatDate(LocalDate.now());

       System.out.println("savePerson LocalDate now : " + now);

       person.setCreatedAt(now);
       return personRepository.save(person);
   }

    public Optional<Person> findPersonById(String id) {
        return personRepository.findById(id);
    }

    public void deletePerson(String id) {
        Optional<Person> movie = personRepository.findById(id);
        if(movie.isPresent()) {
            Person deletedPerson = movie.get();
            personRepository.delete(deletedPerson);
        }
    }

    public List<Person> allPersons() {
        List<Person> persons = new ArrayList<>();
        personRepository.findAll().forEach(persons::add);
        return persons;
    }

    public void updatePerson(String id,Person personForUpdate) {

        personRepository.findById(id).ifPresentOrElse(person -> {
                    person.setName(personForUpdate.getName());
                    person.setSurname(personForUpdate.getSurname());
                    person.setUsername(personForUpdate.getUsername());
                    person.setBirthDate(personForUpdate.getBirthDate());
                    person.setEmail(personForUpdate.getEmail());
                    person.setPassword(personForUpdate.getPassword());
                    person.setActive(personForUpdate.getActive());
                    person.setCreatedAt(personForUpdate.getCreatedAt());
                    personRepository.save(person);

                }, () -> {
                    throw new RuntimeException("No Record With this Id!");
                }
        );

    }
}

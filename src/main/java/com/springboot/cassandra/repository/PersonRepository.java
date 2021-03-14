package com.springboot.cassandra.repository;

import com.springboot.cassandra.model.Person;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends CassandraRepository<Person, String> {

}

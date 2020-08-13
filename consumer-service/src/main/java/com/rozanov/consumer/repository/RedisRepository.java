package com.rozanov.consumer.repository;

import com.rozanov.consumer.dto.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RedisRepository extends CrudRepository<Person, String> {

}

package com.rozanov.consumer.service;

import com.rozanov.consumer.dto.Person;
import com.rozanov.consumer.repository.RedisRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@RequiredArgsConstructor
public class RedisService {

    private final RedisRepository redisRepository;

    public void addPerson(Person person) {
        redisRepository.save(person);
    }

    public Optional<Person> getPerson(String id) {
        return redisRepository.findById(id);
    }
}

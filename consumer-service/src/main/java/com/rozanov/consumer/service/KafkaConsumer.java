package com.rozanov.consumer.service;

import com.rozanov.consumer.dto.Person;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@Slf4j
@RequiredArgsConstructor
public class KafkaConsumer {
    private final RedisService redisService;

    @KafkaListener(id = "roz", topics = "topicRating")
    public void listen(Person person) {
        log.info(String.format("first name: %s, last name: %s, social rating: %s", person.getFirstName(), person.getLastName(), calculateSocialRating(person)));
        redisService.addPerson(person);
        final Optional<Person> person1 = redisService.getPerson(person.getId());
        person1.ifPresentOrElse(
                p -> log.info("Data from redis, {}", p),
                () -> log.error("Couldn't find anything inside redis")
        );
    }

    private double calculateSocialRating(Person person){
        return person.getAge()*person.getSeed();
    }
}

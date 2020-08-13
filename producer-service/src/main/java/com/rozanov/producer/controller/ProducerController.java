package com.rozanov.producer.controller;

import com.rozanov.producer.dto.Person;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
public class ProducerController {
    private final KafkaTemplate<Object, Object> template;

    @Value("${application.calculationSeed:1}")
    private double seed;

    @PostMapping(path = "/send", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void send(@RequestBody Person person) {
        person.setSeed(seed);
        log.info(person.toString());
        this.template.send("topicRating", person);
    }
}

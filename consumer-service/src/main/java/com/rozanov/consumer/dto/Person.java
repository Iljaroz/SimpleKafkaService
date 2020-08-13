package com.rozanov.consumer.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;
import java.util.UUID;

@Data
@RedisHash("Person")
public class Person implements Serializable {
    String id;
    @JsonProperty("first_name")
    String firstName;
    @JsonProperty("last_name")
    String lastName;
    int age;
    double seed;

    public Person(){
        this.id = UUID.randomUUID().toString();
    }
}

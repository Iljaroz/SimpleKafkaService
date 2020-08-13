package com.rozanov.producer.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class Person implements Serializable {
    @JsonProperty("first_name")
    String firstName;
    @JsonProperty("last_name")
    String lastName;
    int age;

    double seed;
}

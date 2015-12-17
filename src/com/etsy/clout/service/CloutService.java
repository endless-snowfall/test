package com.etsy.clout.service;

import java.util.Map;
import java.util.Optional;

import com.etsy.clout.concepts.Person;

public interface CloutService {

    void follows(Person source, Person target);

    Optional<Integer> getClout(Person person);

    Map<Person, Integer> getAllClout();
}

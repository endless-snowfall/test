package com.etsy.clout.service;

import java.util.Map;
import java.util.Optional;

import com.etsy.clout.concepts.Person;

public interface CloutService {

    void follows(Person follower, Person followed);

    Optional<Integer> getClout(Person person);

    Map<Person, Integer> getAllClout();
}

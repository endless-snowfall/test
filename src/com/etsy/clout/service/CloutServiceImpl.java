package com.etsy.clout.service;

import java.util.HashMap;
import java.util.Map;

import com.etsy.clout.concepts.Person;

public class CloutServiceImpl implements CloutService {

    private Map<Person, Person> follows = new HashMap<>();
    private Map<Person, Integer> clout = new HashMap<>();

    @Override
    public void follows(Person source, Person target) {
        if (isAlreadyFollowing(source, target)) {
            return;
        }

        int sourceClout = clout.computeIfAbsent(source, person -> 0);
        subtractFollowerClout(source, sourceClout);

        clout.computeIfAbsent(target, person -> 0);
        follows.put(source, target);
        addFollowerClout(target, sourceClout);
    }

    @Override
    public int getClout(Person person) {
        return clout.getOrDefault(person, 0);
    }

    @Override
    public Map<Person, Integer> getAllClout() {
        return clout;
    }

    private boolean isAlreadyFollowing(Person source, Person target) {
        return follows.containsKey(source) && follows.get(source).equals(target);
    }

    private void subtractFollowerClout(Person source, int sourceClout) {
        Person person = follows.get(source);

        // subtract from previously followed and all "ancestors"
        while (person != null) {
            int oldClout = clout.get(person);
            clout.put(person, oldClout - (sourceClout + 1));
            // TODO
            System.out.println(String.format("subtract: %s, %s", person.getName(), sourceClout + 1));
            person = follows.get(person);
        }
    }

    private void addFollowerClout(Person target, int sourceClout) {
        // add to all of newly followed and all "ancestors"
        while (target != null) {
            int oldClout = clout.get(target);
            clout.put(target, oldClout + (sourceClout + 1));
            // TODO
            System.out.println(String.format("add: %s, %s", target.getName(), sourceClout + 1));
            target = follows.get(target);
        }
    }
}

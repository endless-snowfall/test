package com.etsy.clout.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import com.etsy.clout.concepts.Person;

public class CloutServiceImpl implements CloutService {

    private Map<Person, Person> follows = new HashMap<>();
    private Map<Person, Integer> clout = new HashMap<>();

    @Override
    public void follows(Person follower, Person followed) {
        if (isAlreadyFollowing(follower, followed)) {
            return;
        }

        int followerClout = clout.computeIfAbsent(follower, person -> 0);
        subtractFollowerClout(follower, followerClout);

        clout.computeIfAbsent(followed, person -> 0);
        follows.put(follower, followed);
        addFollowerClout(followed, followerClout);
    }

    @Override
    public Optional<Integer> getClout(Person person) {
        return Optional.ofNullable(clout.get(person));
    }

    @Override
    public Map<Person, Integer> getAllClout() {
        return clout;
    }

    private boolean isAlreadyFollowing(Person follower, Person followed) {
        return follows.containsKey(follower) && follows.get(follower).equals(followed);
    }

    private void subtractFollowerClout(Person follower, int followerClout) {
        Person person = follows.get(follower);

        // subtract from previously followed and all "ancestors"
        while (person != null) {
            int oldClout = clout.get(person);
            clout.put(person, oldClout - (followerClout + 1));
            System.out.println(String.format("subtract: %s, %s", person.getName(), followerClout + 1));
            person = follows.get(person);
        }
    }

    private void addFollowerClout(Person followed, int followerClout) {
        // add to all of newly followed and all "ancestors"
        while (followed != null) {
            int oldClout = clout.get(followed);
            clout.put(followed, oldClout + (followerClout + 1));
            System.out.println(String.format("add: %s, %s", followed.getName(), followerClout + 1));
            followed = follows.get(followed);
        }
    }
}

package com.etsy.clout.command;

import java.util.Optional;

import com.etsy.clout.concepts.Person;
import com.etsy.clout.service.CloutService;

import lombok.AllArgsConstructor;
import lombok.Value;

@AllArgsConstructor(staticName = "of")
@Value
public class CloutCommand implements Command {

    private CloutService cloutService;
    private Optional<Person> maybePerson;

    @Override
    public void execute() {
        if (maybePerson.isPresent()) {
            Person person = maybePerson.get();
            Optional<Integer> maybeClout = cloutService.getClout(person);
            outputClout(person, maybeClout.isPresent() ? maybeClout.get() : 0);
        } else {
            cloutService.getAllClout().forEach(this::outputClout);
        }
    }

    private void outputClout(Person person, Integer clout) {
        System.out.println(String.format("%s has %s.",
            person.getName(),
            getFollowerString(clout)));
    }

    private String getFollowerString(int clout) {
        if (clout == 0) {
            return "no followers";
        } else if (clout == 1) {
            return "1 follower";
        } else {
            return clout + " followers";
        }
    }
}

package com.etsy.clout.command;

import java.util.Optional;

import com.etsy.clout.concepts.Person;
import com.etsy.clout.service.CloutService;

import lombok.AllArgsConstructor;

@AllArgsConstructor(staticName = "of")
public class CommandFactory {

    private static final String FOLLOWS = " follows ";
    private static final String CLOUT = "clout";

    private CloutService cloutService;

    public Command buildCommand(String input) {
        if (input.contains(FOLLOWS)) {
            return buildFollowCommand(input);
        }

        return buildCloutCommand(input);
    }

    private FollowCommand buildFollowCommand(String input) {
        int followsIndex = input.indexOf(FOLLOWS);
        return FollowCommand.of(
            cloutService,
            Person.of(input.substring(0, followsIndex)),
            Person.of(input.substring(followsIndex + FOLLOWS.length())));
    }

    private CloutCommand buildCloutCommand(String input) {
        Optional<Person> maybePerson = input.equals(CLOUT)
            ? Optional.empty()
            : Optional.of(Person.of(input.substring(CLOUT.length() + 1)));
        return CloutCommand.of(cloutService, maybePerson);
    }
}

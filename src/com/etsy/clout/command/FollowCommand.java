package com.etsy.clout.command;

import com.etsy.clout.concepts.Person;
import com.etsy.clout.service.CloutService;

import lombok.AllArgsConstructor;
import lombok.Value;

@AllArgsConstructor(staticName = "of")
@Value
public class FollowCommand implements Command {

    private CloutService cloutService;
    private Person source;
    private Person target;

    @Override
    public void execute() {
        if (source.equals(target)) {
            System.out.println("Interesting, but that doesn't make sense.");
            return;
        }

        cloutService.follows(source, target);
        System.out.println("OK!");
    }
}

package com.etsy.clout.command;

import com.etsy.clout.concepts.Person;
import com.etsy.clout.service.CloutService;

import lombok.AllArgsConstructor;
import lombok.Value;

@AllArgsConstructor(staticName = "of")
@Value
public class FollowCommand implements Command {

    private CloutService cloutService;
    private Person follower;
    private Person followed;

    @Override
    public void execute() {
        if (follower.equals(followed)) {
            System.out.println("Interesting, but that doesn't make sense.");
            return;
        }

        cloutService.follows(follower, followed);
        System.out.println("OK!");
    }
}

package com.etsy.clout.command;

import static org.junit.Assert.*;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import com.etsy.clout.concepts.Person;
import com.etsy.clout.service.CloutService;

public class CommandFactoryTest {

    @Mock CloutService cloutService;

    private CommandFactory factory;

    @Before
    public void before() {
        factory = CommandFactory.of(cloutService);
    }

    @Test
    public void buildFollowCommand() {
        Command command = factory.buildCommand("Neymar follows Xavi");

        assertTrue(command instanceof FollowCommand);
        FollowCommand followCommand = (FollowCommand) command;

        assertEquals(cloutService, followCommand.getCloutService());
        assertEquals(Person.of("Neymar"), followCommand.getFollower());
        assertEquals(Person.of("Xavi"), followCommand.getFollowed());
    }

    @Test
    public void buildFollowCommand_SamePerson() {
        Command command = factory.buildCommand("Messi follows Messi");

        assertTrue(command instanceof FollowCommand);
        FollowCommand followCommand = (FollowCommand) command;

        assertEquals(cloutService, followCommand.getCloutService());
        assertEquals(Person.of("Messi"), followCommand.getFollower());
        assertEquals(Person.of("Messi"), followCommand.getFollowed());
        assertEquals(followCommand.getFollower(), followCommand.getFollowed());
    }

    @Test
    public void buildCloutCommand_Single() {
        Command command = factory.buildCommand("clout Messi");

        assertTrue(command instanceof CloutCommand);
        CloutCommand cloutCommand = (CloutCommand) command;

        assertEquals(cloutService, cloutCommand.getCloutService());
        Optional<Person> maybePerson = cloutCommand.getMaybePerson();
        assertTrue(maybePerson.isPresent());
        assertEquals(Person.of("Messi"), maybePerson.get());
    }

    @Test
    public void buildCloutCommand_All() {
        Command command = factory.buildCommand("clout");

        assertTrue(command instanceof CloutCommand);
        CloutCommand cloutCommand = (CloutCommand) command;

        assertEquals(cloutService, cloutCommand.getCloutService());
        Optional<Person> maybePerson = cloutCommand.getMaybePerson();
        assertFalse(maybePerson.isPresent());
    }
}

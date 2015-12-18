package com.etsy.clout.service;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.etsy.clout.concepts.Person;

public class CloutServiceImplTest {

    private static final Person ANTHONY = Person.of("Anthony");
    private static final Person MIKE = Person.of("Mike");
    private static final Person BOB = Person.of("Bob");
    private static final Person DAVE = Person.of("Dave");

    private CloutService cloutService;

    @Before
    public void before() {
        cloutService = new CloutServiceImpl();
    }

    @Test
    public void follows_Double() {
        cloutService.follows(ANTHONY, MIKE);

        assertEquals(0, cloutService.getClout(ANTHONY));
        assertEquals(1, cloutService.getClout(MIKE));
    }

    @Test
    public void follows_Triple() {
        cloutService.follows(ANTHONY, MIKE);
        cloutService.follows(MIKE, BOB);

        assertEquals(0, cloutService.getClout(ANTHONY));
        assertEquals(1, cloutService.getClout(MIKE));
        assertEquals(2, cloutService.getClout(BOB));
    }

    @Test
    public void follows_Triangle() {
        cloutService.follows(ANTHONY, BOB);
        cloutService.follows(MIKE, BOB);

        assertEquals(0, cloutService.getClout(ANTHONY));
        assertEquals(0, cloutService.getClout(MIKE));
        assertEquals(2, cloutService.getClout(BOB));
    }

    @Test
    public void follows_TriangleReparent() {
        cloutService.follows(ANTHONY, BOB);
        cloutService.follows(MIKE, BOB);

        assertEquals(0, cloutService.getClout(ANTHONY));
        assertEquals(0, cloutService.getClout(MIKE));
        assertEquals(2, cloutService.getClout(BOB));

        cloutService.follows(MIKE, DAVE);

        assertEquals(0, cloutService.getClout(ANTHONY));
        assertEquals(0, cloutService.getClout(MIKE));
        assertEquals(1, cloutService.getClout(BOB));
        assertEquals(1, cloutService.getClout(DAVE));
    }

    @Test
    public void follows_Cycle() {
        cloutService.follows(ANTHONY, MIKE);
        cloutService.follows(MIKE, ANTHONY);

        assertEquals(1, cloutService.getClout(ANTHONY));
        assertEquals(1, cloutService.getClout(MIKE));
    }
}

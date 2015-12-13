package com.netflix.search.parser;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

public class SolutionTest {

    private Solution solution;

    @Before
    public void before() {
        solution = new Solution();
    }

    @Test
    public void test1() {
        assertTrue(solution.parse(null, Sets.newHashSet("blah")).isEmpty());
    }

    @Test
    public void test2() {
        assertTrue(solution.parse("", Sets.newHashSet("blah")).isEmpty());
    }

    @Test
    public void test3() {
        assertEquals(
            Lists.newArrayList("blah"),
            solution.parse("blah", Sets.newHashSet("blah")));
    }

    @Test
    public void test4() {
        assertTrue(solution.parse("hello", Sets.newHashSet("world")).isEmpty());
    }

    @Test
    public void test5() {
        assertEquals(
            Lists.newArrayList("home", "depot"),
            solution.parse("homedepot", Sets.newHashSet("home", "depot")));
    }

    @Test
    public void test6() {
        assertTrue(solution.parse("homedepot", Sets.newHashSet("home", "depott")).isEmpty());
    }
}

package com.airbnb.palindrome.pairs;

import static common.TestUtils.*;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

@SuppressWarnings("unchecked")
public class SolutionTest {

    private Solution solution;

    @Before
    public void before() {
        solution = new Solution();
    }

    @Test
    public void test1() {
        assertTrue(solution.getPalindromePairs(null).isEmpty());
    }

    @Test
    public void test2() {
        assertTrue(solution.getPalindromePairs(Collections.emptySet()).isEmpty());
    }

    @Test
    public void test3() {
        assertTrue(solution.getPalindromePairs(Sets.newHashSet("blah")).isEmpty());
    }

    @Test
    public void test4() {
        assertListsEqualUnordered(
            Lists.newArrayList(
                Lists.newArrayList("bag", "gab"),
                Lists.newArrayList("gab", "bag")),
            solution.getPalindromePairs(Sets.newHashSet("bag", "gab")));
    }

    @Test
    public void test5() {
        List<List<String>> expected = new ArrayList<>();
        expected.add(Lists.newArrayList("race", "car"));
        assertListsEqualUnordered(expected, solution.getPalindromePairs(Sets.newHashSet("race", "car")));
    }

    @Test
    public void test6() {
        HashSet<String> input = Sets.newHashSet("gr", "reirxyx", "bag", "xyxreir", "tac", "tic", "race", "car", "gab", "rier");

        assertListsEqualUnordered(
            Lists.newArrayList(
                Lists.newArrayList("race", "car"),
                Lists.newArrayList("bag", "gab"),
                Lists.newArrayList("gab", "bag"),
                Lists.newArrayList("reirxyx", "rier"),
                Lists.newArrayList("rier", "xyxreir")),
            solution.getPalindromePairs(input));
    }
}

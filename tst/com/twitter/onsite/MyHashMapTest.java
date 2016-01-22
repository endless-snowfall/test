package com.twitter.onsite;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MyHashMapTest {

    private MyHashMap<String, Integer> solution;

    @Before
    public void before() {
        solution = new MyHashMap<>();
    }

    @Test
    public void test1() {
        assertTrue(solution.isEmpty());
        assertNull(solution.get("anthony"));
        assertNull(solution.put("anthony", 10101));
        assertEquals(1, solution.size());
        assertEquals(10101, solution.get("anthony").intValue());
        assertEquals(10101, solution.put("anthony", 20202).intValue());
        assertEquals(20202, solution.get("anthony").intValue());
    }
}

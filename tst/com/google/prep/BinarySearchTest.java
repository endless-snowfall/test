package com.google.prep;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BinarySearchTest {

    private BinarySearchRecursive solution;

    @Before
    public void before() {
        solution = new BinarySearchRecursive();
    }

    @Test
    public void test1() {
        for (int i = 0; i <= 10; i++) {
            assertEquals(i, solution.binarySearch(new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }, i));
        }
    }

    @Test
    public void test2() {
        assertEquals(-1, solution.binarySearch(new int[] { 0, 1, 2, 3, 4, 5, 7, 8, 9, 10 }, 6));
    }

    @Test
    public void test3() {
        assertEquals(-1, solution.binarySearch(new int[] { 0, 1, 2, 3, 4, 5, 7, 8, 9, 10 }, -1));
    }

    @Test
    public void test4() {
        assertEquals(-1, solution.binarySearch(new int[] { 0, 1, 2, 3, 4, 5, 7, 9, 10 }, 11));
    }

    @Test
    public void test5() {
        assertEquals(-1, solution.binarySearch(new int[] { 0, 1, 2, 3, 4, 5, 7, 9, 10 }, 8));
    }
}

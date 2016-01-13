package com.airbnb.nested.list.iterator;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.google.common.collect.Lists;

import common.TestBase;

public class SolutionTest extends TestBase {

    private Solution solution;

    @Test(expected = IndexOutOfBoundsException.class)
    public void empty_Next() {
        List<List<Integer>> input = null;
        solution = new Solution(input);

        assertFalse(solution.hasNext());
        solution.next();
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void empty_Remove() {
        List<List<Integer>> input = null;
        solution = new Solution(input);

        assertFalse(solution.hasNext());
        solution.remove();
    }

    @Test
    public void empty_SingleListWithSingleItem() {
        List<List<Integer>> input = Lists.newArrayList();
        input.add(Lists.newArrayList(1));
        solution = new Solution(input);

        assertTrue(solution.hasNext());
        assertEquals(1, solution.next());
        solution.remove();
        assertFalse(solution.hasNext());
    }

    @Test
    public void empty_TwoLists_SingleItemEach() {
        List<List<Integer>> input = Lists.newArrayList();
        input.add(Lists.newArrayList(1));
        input.add(Lists.newArrayList(2));
        solution = new Solution(input);

        assertTrue(solution.hasNext());
        assertEquals(1, solution.next());
        solution.remove();
        assertEquals(2, solution.next());
        solution.remove();
        assertFalse(solution.hasNext());
    }

    @Test
    public void empty_SeveralLists_MultiItemEach() {
        List<List<Integer>> input = Lists.newArrayList();
        input.add(Lists.newArrayList(1, 2, 3));
        input.add(Lists.newArrayList(4));
        input.add(Lists.newArrayList(5, 6));
        solution = new Solution(input);

        for (int i = 1; i <= 6; i++) {
            assertTrue(solution.hasNext());
            assertEquals(i, solution.next());
        }
        assertFalse(solution.hasNext());
    }
}

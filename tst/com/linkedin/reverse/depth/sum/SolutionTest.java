package com.linkedin.reverse.depth.sum;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.Lists;

import common.TestBase;

public class SolutionTest extends TestBase {

    private Solution solution;

    @Before
    public void before() {
        solution = new Solution();
    }

    @Test
    public void test1() {
        NestedInteger a = new NestedIntegerImpl(
            Lists.newArrayList(new NestedIntegerImpl(1), new NestedIntegerImpl(1)));

        NestedInteger b = new NestedIntegerImpl(2);

        // {{1,1},2,{1,1}}
        List<NestedInteger> input = Lists.newArrayList(a, b, a);

        assertEquals(8, solution.reverseDepthSum(input));
    }

    @Test
    public void test2() {
        NestedInteger c = new NestedIntegerImpl(
            Lists.newArrayList(new NestedIntegerImpl(6)));

        NestedInteger b = new NestedIntegerImpl(
            Lists.newArrayList(new NestedIntegerImpl(4), c));

        NestedInteger a = new NestedIntegerImpl(
            Lists.newArrayList(new NestedIntegerImpl(1), b));

        // {1,{4,{6}}}
        List<NestedInteger> input = Lists.newArrayList(a);

        assertEquals(17, solution.reverseDepthSum(input));
    }
}

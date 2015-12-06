package com.groupon.count.land.masses;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import common.TestBase;

public class DiagonalSolutionTest extends TestBase {

    private DiagonalSolution solution;

    @Before
    public void before() {
        solution = new DiagonalSolution();
    }

    @Test
    public void test1() {
        assertEquals(0, solution.countLandMasses(null));
    }

    @Test
    public void test2() {
        assertEquals(0, solution.countLandMasses(new int[][] { {} }));
    }

    @Test
    public void test3() {
        int[][] map = { { 0 } };
        assertEquals(0, solution.countLandMasses(map));
    }

    @Test
    public void test4() {
        int[][] map = { { 1 } };
        assertEquals(1, solution.countLandMasses(map));
    }

    @Test
    public void test5() {
        int[][] map = {
            { 0, 0, 0 },
            { 0, 0, 0 },
            { 0, 0, 0 },
        };
        assertEquals(0, solution.countLandMasses(map));
    }

    @Test
    public void test6() {
        int[][] map = {
            { 0, 0, 0 },
            { 0, 1, 0 },
            { 0, 0, 0 },
        };
        assertEquals(1, solution.countLandMasses(map));
    }

    @Test
    public void test7() {
        int[][] map = {
            { 1, 1, 1 },
            { 0, 0, 0 },
            { 0, 0, 0 },
        };
        assertEquals(1, solution.countLandMasses(map));
    }

    @Test
    public void test8() {
        int[][] map = {
            { 1, 0, 0 },
            { 1, 0, 0 },
            { 1, 0, 0 },
        };
        assertEquals(1, solution.countLandMasses(map));
    }

    @Test
    public void test9() {
        int[][] map = {
            { 1, 1, 1 },
            { 1, 0, 0 },
            { 1, 0, 0 },
        };
        assertEquals(1, solution.countLandMasses(map));
    }

    @Test
    public void test10() {
        int[][] map = {
            { 1, 1, 1 },
            { 0, 0, 1 },
            { 1, 1, 1 },
        };
        assertEquals(1, solution.countLandMasses(map));
    }

    @Test
    public void test11() {
        int[][] map = {
            { 1, 0, 0 },
            { 0, 1, 0 },
            { 0, 0, 1 },
        };
        assertEquals(1, solution.countLandMasses(map));
    }

    @Test
    public void test12() {
        int[][] map = {
            { 1, 0, 1, 0, 1, 0, 1 },
            { 1, 0, 1, 0, 1, 0, 1 },
            { 0, 1, 0, 1, 0, 1, 0 },
        };
        assertEquals(1, solution.countLandMasses(map));
    }
}

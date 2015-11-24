package com.netflix;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.Lists;
import com.netflix.PathGenerator.BoardingPass;

import common.TestBase;

public class PathGeneratorTest extends TestBase {

    private PathGenerator generator;

    @Before
    public void before() {
        generator = new PathGenerator();
    }

    @Test
    public void test1() {
        List<BoardingPass> passes = Lists.newArrayList(
            new BoardingPass("LAX", "SFO"),
            new BoardingPass("SFO", "SJC"),
            new BoardingPass("SJC", "SEA"),
            new BoardingPass("SEA", "NYC"),
            new BoardingPass("NYC", "SAN"));

        assertEquals(Lists.newArrayList(
            "LAX", "SFO", "SJC", "SEA", "NYC", "SAN"),
            generator.getPath(passes));
    }
}

package com.netflix.boarding.passes;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.Lists;
import com.netflix.boarding.passes.ConcisePathGenerator;
import com.netflix.boarding.passes.PathGenerator.BoardingPass;

import common.TestBase;

public class PathGeneratorTest extends TestBase {

    private ConcisePathGenerator generator;

    @Before
    public void before() {
        generator = new ConcisePathGenerator();
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

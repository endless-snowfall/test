package com.snapchat.parser;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ParserTest {

    private WhileLoopParser parser;

    @Before
    public void before() {
        parser = new WhileLoopParser();
    }

    @Test
    public void test1() {
        assertEquals("", parser.parse(null));
    }

    @Test
    public void test2() {
        assertEquals("", parser.parse(null));
    }

    @Test
    public void test3() {
        assertEquals("Anthony", parser.parse("Anthony"));
    }

    @Test
    public void test4() {
        assertEquals("John|Smith|john.smith@gmail.com|Los Angeles|1", parser.parse("John,Smith,john.smith@gmail.com,Los Angeles,1"));
    }

    @Test
    public void test5() {
        assertEquals("Jane|Roberts|janer@msn.com|San Francisco, CA|0", parser.parse("Jane,Roberts,janer@msn.com,\"San Francisco, CA\",0"));
    }

    @Test
    public void test6() {
        assertEquals("Alexandra \"Alex\"|Menendez|alex.menendez@gmail.com|Miami|1",
            parser.parse("\"Alexandra \"\"Alex\"\"\",Menendez,alex.menendez@gmail.com,Miami,1"));
    }

    @Test
    public void test7() {
        assertEquals("Alexandra, \"Alex\"|Menendez|alex.menendez@gmail.com|Miami|1",
            parser.parse("\"Alexandra, \"\"Alex\"\"\",Menendez,alex.menendez@gmail.com,Miami,1"));
    }
}

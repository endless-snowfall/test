package com.snapchat.onsite;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.Lists;
import com.snapchat.onsite.ChooseYourOwnAdventure.Node;

public class ChooseYourOwnAdventureTest {

    private ChooseYourOwnAdventure solution;

    @Before
    public void before() {
        solution = new ChooseYourOwnAdventure();
    }

    @Test
    public void test() {
        Node page4 = new Node(Lists.newArrayList(), 2);
        Node page3 = new Node(Lists.newArrayList(page4), 10);
        Node page2 = new Node(Lists.newArrayList(page3), -8);
        Node page1 = new Node(Lists.newArrayList(page2, page4), 3);

        assertEquals(7, solution.getMaxScore(page1));
    }
}

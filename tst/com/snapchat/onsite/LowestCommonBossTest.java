package com.snapchat.onsite;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.Lists;
import com.snapchat.onsite.LowestCommonBoss.Employee;

public class LowestCommonBossTest {

    private LowestCommonBoss solution;

    @Before
    public void before() {
        solution = new LowestCommonBoss();
    }

    @Test
    public void test1() {
        Employee x8 = new Employee("x8", Lists.newArrayList());

        Employee x4 = new Employee("x4", Lists.newArrayList());
        Employee x5 = new Employee("x5", Lists.newArrayList());
        Employee x6 = new Employee("x6", Lists.newArrayList());

        Employee x7 = new Employee("x7", Lists.newArrayList(x8));

        Employee x1 = new Employee("x1", Lists.newArrayList(x4, x5));
        Employee x2 = new Employee("x2", Lists.newArrayList());
        Employee x3 = new Employee("x3", Lists.newArrayList(x6, x7));

        Employee ceo = new Employee("ceo", Lists.newArrayList(x1, x2, x3));

        assertEquals("ceo", solution.getManager(ceo, "x1", "x2"));
        assertEquals("ceo", solution.getManager(ceo, "x1", "x3"));
        assertEquals("x1", solution.getManager(ceo, "x4", "x5"));
        assertEquals("x3", solution.getManager(ceo, "x6", "x8"));
        assertEquals("ceo", solution.getManager(ceo, "x2", "x8"));
        assertEquals("ceo", solution.getManager(ceo, "x4", "x8"));
        assertEquals("x3", solution.getManager(ceo, "x7", "x8"));
    }
}

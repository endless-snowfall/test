package com.snapchat.onsite;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.snapchat.onsite.ContactGrouper.Contact;

public class ContactGrouperTest {

    private ContactGrouper solution;

    private Contact al = new Contact("A", 1);
    private Contact bob = new Contact("B", 2);
    private Contact joe = new Contact("J", 3);
    private Contact jake = new Contact("J", 2);
    private Contact clark = new Contact("A", 4);
    private Contact cory = new Contact("A", 3);

    @Test
    public void test1() {
        solution = new ContactGrouper(Lists.newArrayList(al, bob, joe));

        Set<Set<Contact>> expected = new HashSet<>();
        expected.add(Sets.newHashSet(al));
        expected.add(Sets.newHashSet(bob));
        expected.add(Sets.newHashSet(joe));

        assertEquals(expected, solution.groupContacts());
    }

    @Test
    public void test2() {
        solution = new ContactGrouper(Lists.newArrayList(al, clark));

        Set<Set<Contact>> expected = new HashSet<>();
        expected.add(Sets.newHashSet(al, clark));

        assertEquals(expected, solution.groupContacts());
    }

    @Test
    public void test3() {
        solution = new ContactGrouper(Lists.newArrayList(al, bob, joe, clark, cory));

        Set<Set<Contact>> expected = new HashSet<>();
        expected.add(Sets.newHashSet(al, joe, clark, cory));
        expected.add(Sets.newHashSet(bob));

        assertEquals(expected, solution.groupContacts());
    }

    @Test
    public void test4() {
        solution = new ContactGrouper(Lists.newArrayList(al, bob, joe, jake, clark, cory));

        Set<Set<Contact>> expected = new HashSet<>();
        expected.add(Sets.newHashSet(al, bob, joe, jake, clark, cory));

        assertEquals(expected, solution.groupContacts());
    }
}

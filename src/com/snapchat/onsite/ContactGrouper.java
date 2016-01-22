package com.snapchat.onsite;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.google.common.collect.Sets;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

public class ContactGrouper {

    @ToString
    @Getter
    @AllArgsConstructor
    public static class Contact {

        private String name;
        private int phoneNumber;
    }

    @ToString
    @Getter
    @AllArgsConstructor
    public static class Group {

        private Set<String> names;
        private Set<Integer> phoneNumbers;

        public boolean contains(Contact contact) {
            return names.contains(contact.getName()) || phoneNumbers.contains(contact.getPhoneNumber());
        }
    }

    private Collection<Contact> contacts;
    private Map<String, Set<Contact>> nameLookup = new HashMap<>();
    private Map<Integer, Set<Contact>> phoneNumberLookup = new HashMap<>();
    private Set<Group> groups = new HashSet<>();

    public ContactGrouper(Collection<Contact> contacts) {
        this.contacts = contacts;

        for (Contact contact : contacts) {
            Set<Contact> nameContacts = nameLookup.getOrDefault(contact.getName(), new HashSet<>());
            nameContacts.add(contact);
            nameLookup.put(contact.getName(), nameContacts);

            Set<Contact> phoneNumberContacts = phoneNumberLookup.getOrDefault(contact.getPhoneNumber(), new HashSet<>());
            phoneNumberContacts.add(contact);
            phoneNumberLookup.put(contact.getPhoneNumber(), phoneNumberContacts);

            groups.add(new Group(
                Sets.newHashSet(contact.getName()),
                Sets.newHashSet(contact.getPhoneNumber())));
        }
    }

    public Set<Set<Contact>> groupContacts() {
        for (Contact contact : contacts) {
            Set<Group> groupsToMerge = new HashSet<>();
            for (Group group : groups) {
                if (group.contains(contact)) {
                    groupsToMerge.add(group);
                }
            }
            merge(groupsToMerge);
        }
        return buildResult();
    }

    private void merge(Set<Group> groupsToMerge) {
        if (groupsToMerge.size() == 1) {
            return;
        }

        Set<String> names = new HashSet<>();
        Set<Integer> phoneNumbers = new HashSet<>();
        for (Group group : groupsToMerge) {
            names.addAll(group.getNames());
            phoneNumbers.addAll(group.getPhoneNumbers());
        }

        groups.removeAll(groupsToMerge);
        groups.add(new Group(names, phoneNumbers));
    }

    private Set<Set<Contact>> buildResult() {
        Set<Set<Contact>> result = new HashSet<>();
        for (Group group : groups) {
            Set<Contact> subresult = new HashSet<>();
            for (String name : group.getNames()) {
                subresult.addAll(nameLookup.get(name));
            }
            for (int phoneNumber : group.getPhoneNumbers()) {
                subresult.addAll(phoneNumberLookup.get(phoneNumber));
            }
            result.add(subresult);
        }
        return result;
    }
}

package com.snapchat.onsite;

import static java.util.stream.Collectors.*;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

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
        contacts.forEach(contact -> {
            merge(groups.stream()
                .filter(group -> group.contains(contact))
                .collect(toSet()));
        });
        return buildResult();
    }

    private void merge(Set<Group> groupsToMerge) {
        if (groupsToMerge.size() == 1) {
            return;
        }

        Set<String> names = groupsToMerge.stream()
            .map(Group::getNames)
            .flatMap(Collection::stream)
            .collect(toSet());

        Set<Integer> phoneNumbers = groupsToMerge.stream()
            .map(Group::getPhoneNumbers)
            .flatMap(Collection::stream)
            .collect(toSet());

        groups.removeAll(groupsToMerge);
        groups.add(new Group(names, phoneNumbers));
    }

    private Set<Set<Contact>> buildResult() {
        Set<Set<Contact>> result = new HashSet<>();

        for (Group group : groups) {
            Stream<Contact> nameContacts = group.getNames().stream()
                .map(nameLookup::get)
                .flatMap(Collection::stream);

            Stream<Contact> phoneNumberContacts = group.getPhoneNumbers().stream()
                .map(phoneNumberLookup::get)
                .flatMap(Collection::stream);

            result.add(Stream.concat(nameContacts, phoneNumberContacts).collect(toSet()));
        }

        return result;
    }
}

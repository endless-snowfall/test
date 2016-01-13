package com.airbnb.nested.list.iterator;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

public class Solution {

    @AllArgsConstructor
    @Data
    public static class Location {

        private int listIndex;
        private int sublistIndex;
    }

    private List<List<Integer>> data;
    private Location current;
    private Location previous;

    public Solution(List<List<Integer>> data) {
        this.data = data;
        previous = null;
        current = (data == null) ? null : findNext(new Location(0, 0));
    }

    public boolean hasNext() {
        return current != null;
    }

    public int next() {
        if (current == null) {
            throw new IndexOutOfBoundsException();
        }

        int result = data.get(current.listIndex).get(current.sublistIndex);
        previous = current;
        current = findNext(new Location(current.listIndex, current.sublistIndex + 1));
        return result;
    }

    public void remove() {
        if (previous == null) {
            throw new IndexOutOfBoundsException();
        }

        data.get(previous.listIndex).remove(previous.sublistIndex);
        previous = null;
    }

    private Location findNext(Location location) {
        List<Integer> list = data.get(location.listIndex);
        if (location.sublistIndex < list.size()) {
            return location;
        }

        Location result = null;
        for (int listIndex = location.listIndex + 1; listIndex < data.size(); listIndex++) {
            if (data.get(listIndex).isEmpty()) {
                continue;
            }
            result = new Location(listIndex, 0);
            break;
        }
        return result;
    }
}

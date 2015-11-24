package com.netflix;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.google.common.collect.Iterables;
import com.netflix.PathGenerator.BoardingPass;

public class ConcisePathGenerator {

    public List<String> getPath(List<BoardingPass> passes) {
        return helper(computeForwardMap(passes));
    }

    private Map<String, String> computeForwardMap(List<BoardingPass> passes) {
        Map<String, String> result = new HashMap<>();
        passes.forEach(pass -> result.put(pass.origin, pass.destination));
        return result;
    }

    private List<String> helper(Map<String, String> forward) {
        LinkedList<String> result = new LinkedList<>();
        String random = getStartAirport(forward);
        result.addLast(random);

        // build path towards end of trip
        while (forward.containsKey(random)) {
            String nextRandom = forward.get(random);
            result.addLast(nextRandom);
            random = nextRandom;
        }

        return result;
    }

    private String getStartAirport(Map<String, String> forward) {
        Set<String> forwardKeysCopy = new HashSet<>(forward.keySet());
        forwardKeysCopy.removeAll(forward.values());
        return Iterables.getOnlyElement(forwardKeysCopy);
    }
}

package com.netflix.boarding.passes;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import lombok.AllArgsConstructor;

public class PathGenerator {

    @AllArgsConstructor
    static class BoardingPass {

        String origin;
        String destination;
    }

    public List<String> getPath(List<BoardingPass> passes) {
        Map<String, String> forward = computeForwardMap(passes);
        Map<String, String> backward = computeBackwardMap(passes);

        return helper(forward, backward);
    }

    private Map<String, String> computeForwardMap(List<BoardingPass> passes) {
        Map<String, String> result = new HashMap<>();
        passes.forEach(pass -> result.put(pass.origin, pass.destination));
        return result;
    }

    private Map<String, String> computeBackwardMap(List<BoardingPass> passes) {
        Map<String, String> result = new HashMap<>();
        passes.forEach(pass -> result.put(pass.destination, pass.origin));
        return result;
    }

    private List<String> helper(Map<String, String> forward, Map<String, String> backward) {
        LinkedList<String> result = new LinkedList<>();

        String random = forward.keySet().iterator().next();
        result.addLast(random);

        // build path towards end of trip
        while (forward.containsKey(random)) {
            String nextRandom = forward.get(random);
            result.addLast(nextRandom);
            random = nextRandom;
        }

        // build path towards start of trip
        random = result.get(0);
        while (backward.containsKey(random)) {
            String nextRandom = backward.get(random);
            result.addFirst(nextRandom);
            random = nextRandom;
        }

        return result;
    }
}

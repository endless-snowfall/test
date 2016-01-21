package com.snapchat.onsite;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Getter;

public class ChooseYourOwnAdventure {

    private Map<Node, Integer> cache = new HashMap<>();

    @Getter
    @AllArgsConstructor
    public static class Node {

        private List<Node> neighbors;
        private int score;
    }

    public int getMaxScore(Node node) {
        if (cache.containsKey(node)) {
            return cache.get(node);
        }

        int result = node.getScore();

        if (!node.getNeighbors().isEmpty()) {
            int maxNeighborScore = Integer.MIN_VALUE;
            for (Node neighbor : node.getNeighbors()) {
                maxNeighborScore = Math.max(maxNeighborScore, getMaxScore(neighbor));
            }
            result += maxNeighborScore;
        }

        cache.put(node, result);
        return result;
    }
}

package com.etsy.background.color.ab.test;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;

public class Solution {

    public static class Range {

        public float lowerInclusive;
        public float upperExclusive;

        public Range(float lowerInclusive, float upperExclusive) {
            this.lowerInclusive = lowerInclusive;
            this.upperExclusive = upperExclusive;
        }
    }

    public static void main(String[] args) {
        System.out.println(
            getColorIndex(new float[] { .4f, .3f, .3f }, new Random().nextFloat()));
    }

    private static int getColorIndex(float[] weights, float randomValue) {
        Map<Range, Integer> ranges = buildRangeMap(weights);

        for (Entry<Range, Integer> entry : ranges.entrySet()) {
            Range range = entry.getKey();
            if (randomValue >= range.lowerInclusive && randomValue < range.upperExclusive) {
                return entry.getValue();
            }
        }

        return -1;
    }

    private static Map<Range, Integer> buildRangeMap(float[] weights) {
        Map<Range, Integer> result = new HashMap<>();
        float lastRange = 0.0f;

        for (int i = 0; i < weights.length; i++) {
            float newRange = lastRange + weights[i];
            result.put(new Range(lastRange, newRange), i);
            lastRange = newRange;
        }

        return result;
    }
}

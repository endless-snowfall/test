package com.linkedin.reverse.depth.sum;

import java.util.List;

public class Solution {

    private int maxDepth = 0;
    private int unweightedSum = 0;

    public int reverseDepthSum(List<NestedInteger> input) {
        int increasingDepthSum = increaseDepthSum(1, input);
        return ((maxDepth + 1) * unweightedSum) - increasingDepthSum;
    }

    private int increaseDepthSum(int depth, List<NestedInteger> input) {
        maxDepth = Math.max(maxDepth, depth);
        int result = 0;

        for (NestedInteger n : input) {
            if (n.isInteger()) {
                result += depth * n.getInteger();
                unweightedSum += n.getInteger();
            } else {
                result += increaseDepthSum(depth + 1, n.getList());
            }
        }

        return result;
    }
}

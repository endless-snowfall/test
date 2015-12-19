package com.airbnb.palindrome.pairs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.google.common.collect.Lists;

public class Solution {

    public List<List<String>> getPalindromePairs(Set<String> input) {
        List<List<String>> result = new ArrayList<>();
        if (input == null || input.size() == 0) {
            return result;
        }

        StringBuilder builder = new StringBuilder();
        Set<String> usedTokens = new HashSet<>();

        for (String token : input) {
            lookForSuffix(input, token, builder, usedTokens, result);
            lookForPrefix(input, token, builder, usedTokens, result);
        }

        return result;
    }

    private void lookForSuffix(Set<String> input, String left, StringBuilder suffixBuilder, Set<String> usedTokens, List<List<String>> result) {
        suffixBuilder.setLength(0);
        for (int i = 0; i < left.length(); i++) {
            suffixBuilder.insert(0, left.charAt(i));
            String suffix = suffixBuilder.toString();

            if (input.contains(suffix) && isPalindrome(left.substring(i + 1))) {
                result.add(Lists.newArrayList(left, suffix));
                usedTokens.add(left);
                usedTokens.add(suffix);
            }
        }
    }

    private void lookForPrefix(Set<String> input, String right, StringBuilder prefixBuilder, Set<String> usedTokens, List<List<String>> result) {
        prefixBuilder.setLength(0);
        for (int i = right.length() - 1; i >= 0; i--) {
            prefixBuilder.append(right.charAt(i));
            String prefix = prefixBuilder.toString();

            if (usedTokens.contains(prefix)) {
                continue;
            }

            if (input.contains(prefix) && isPalindrome(right.substring(0, i))) {
                result.add(Lists.newArrayList(prefix, right));
                usedTokens.add(prefix);
                usedTokens.add(right);
            }
        }
    }

    private boolean isPalindrome(String input) {
        for (int i = 0; i < input.length() / 2; i++) {
            if (input.charAt(i) != input.charAt(input.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}

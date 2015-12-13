package com.netflix.search.parser;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class Solution {

    public List<String> parse(String input, Set<String> dictionary) {
        List<String> result = new ArrayList<>();

        if (input == null || input.length() <= 0) {
            return result;
        }

        if (helper(input, dictionary, result)) {
            Collections.reverse(result);
        }

        return result;
    }

    private boolean helper(String input, Set<String> dictionary, List<String> result) {
        if (input.length() == 0) {
            return true;
        } else if (dictionary.contains(input)) {
            result.add(input);
            return true;
        }

        for (int i = 1; i <= input.length(); i++) {
            String token = input.substring(0, i);
            if (dictionary.contains(token) && helper(input.substring(i), dictionary, result)) {
                result.add(token);
                return true;
            }
        }

        return false;
    }
}

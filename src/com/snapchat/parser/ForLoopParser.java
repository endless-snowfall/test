package com.snapchat.parser;

public class ForLoopParser {

    private static final char DUMMY_CHAR = 'x';

    public String parse(String input) {
        if (input == null || input.length() == 0) {
            return "";
        }

        StringBuilder result = new StringBuilder();
        boolean printComma = false;
        boolean printQuotes = false;

        for (int i = 0; i < input.length(); i++) {
            char current = input.charAt(i);
            char next = (i == input.length() - 1) ? DUMMY_CHAR : input.charAt(i + 1);

            if (printQuotes && current == '\"' && next == '\"') {
                result.append(current);
                i++;
                continue;
            }

            if (current == '\"') {
                printComma = !printComma;
                printQuotes = !printQuotes;
                continue;
            }

            if (current == ',' && !printComma) {
                result.append('|');
                continue;
            }

            result.append(current);
        }

        return result.toString();
    }
}

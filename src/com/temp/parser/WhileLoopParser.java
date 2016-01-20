package com.temp.parser;

public class WhileLoopParser {

    private static final char DUMMY_CHAR = 'x';

    public String parse(String input) {
        if (input == null || input.length() == 0) {
            return "";
        }

        StringBuilder result = new StringBuilder();
        boolean printComma = false;
        boolean printQuotes = false;
        int readIndex = 0;
        int lastIndex = input.length() - 1;

        while (readIndex < input.length()) {
            char current = input.charAt(readIndex);

            if (printQuotes && current == '\"') {
                char next = (readIndex == lastIndex) ? DUMMY_CHAR : input.charAt(readIndex + 1);
                if (next == '\"') {
                    result.append(current);
                    readIndex += 2;
                    continue;
                }
            }

            if (current == '\"') {
                printComma = !printComma;
                printQuotes = !printQuotes;
                readIndex++;
                continue;
            }

            if (current == ',' && !printComma) {
                result.append('|');
                readIndex++;
                continue;
            }

            result.append(current);
            readIndex++;
        }

        return result.toString();
    }
}

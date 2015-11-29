package jp.co.indeed.rotation;

import java.util.Scanner;

public class DuplicateRotationSubstringSolution {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int length = sc.nextInt();
            String result = sc.next();
            int M = sc.nextInt();

            for (int i = 0; i < M; i++) {
                int L = sc.nextInt();
                int R = sc.nextInt();
                int K = sc.nextInt();
                result = rotate(result, L, R, K);
            }

            System.out.println(result);
        }
    }

    private static String rotate(String input, int L, int R, int K) {
        String rotationSubstring = input.substring(L - 1, R);
        int rotationSubstringLength = R + 1 - L;

        // determine where the start of the rotated portion is
        int beginIndex = rotationSubstringLength - (K % rotationSubstringLength);

        // duplicate the rotated portion
        rotationSubstring += rotationSubstring;

        return new StringBuilder()
            .append(input.substring(0, L - 1))
            .append(rotationSubstring.substring(beginIndex, beginIndex + rotationSubstringLength))
            .append(input.substring(R))
            .toString();
    }
}

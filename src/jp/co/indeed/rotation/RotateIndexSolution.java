package jp.co.indeed.rotation;

import java.util.Scanner;

public class RotateIndexSolution {

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
        int rotateIndex = R - (K % (R + 1 - L));
        return new StringBuilder()
            .append(input.substring(0, L - 1))
            .append(input.substring(rotateIndex, R))
            .append(input.substring(L - 1, rotateIndex))
            .append(input.substring(R))
            .toString();
    }
}

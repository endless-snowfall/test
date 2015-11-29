package jp.co.indeed.ball;

import static java.util.stream.Collectors.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.IntStream;

public class MapSolution {

    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {
            int N = sc.nextInt();
            int K = sc.nextInt();

            Map<Integer, Integer> map = initializeMap();
            buildMap(map, sc, N);

            int[] result = { 1, 2, 3, 4, 5, 6, 7, 8 };

            for (int i = 0; i < K % (8 * 7 * 5 * 3); i++) {
                result = remap(result, map);
            }

            System.out.println(Arrays.stream(result)
                .boxed()
                .map(i -> i.toString())
                .collect(joining(" ")));
        }
    }

    private static Map<Integer, Integer> initializeMap() {
        Map<Integer, Integer> result = new HashMap<>();
        IntStream.range(0, 8).forEach(i -> result.put(i, i));
        return result;
    }

    private static void buildMap(Map<Integer, Integer> map, Scanner scanner, int N) {
        for (int i = 0; i < N; i++) {
            int A = scanner.nextInt();
            int B = scanner.nextInt();
            swap(map, A - 1, B - 1);
        }
    }

    private static void swap(Map<Integer, Integer> map, int a, int b) {
        int temp = map.get(a);
        map.put(a, map.get(b));
        map.put(b, temp);
    }

    private static int[] remap(int[] previousResult, Map<Integer, Integer> map) {
        int[] result = new int[8];
        for (int i = 0; i < 8; i++) {
            result[i] = previousResult[map.get(i)];
        }
        return result;
    }
}

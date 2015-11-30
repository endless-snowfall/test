package jp.co.indeed.ball;

import static java.util.stream.Collectors.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class ConciseDisjointCycleFormSolution {

    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {
            int N = sc.nextInt();
            int K = sc.nextInt();
            int[] balls = { 0, 1, 2, 3, 4, 5, 6, 7 };

            for (int i = 0; i < N; i++) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                swap(balls, a - 1, b - 1);
            }

            // Disjoint cycle form
            List<List<Integer>> disjointCycles = getDisjointCycles(balls);

            // Build result
            System.out.println(Arrays.stream(makeResult(disjointCycles, K))
                .boxed()
                .map(i -> i + 1)
                .map(i -> i.toString())
                .collect(joining(" ")));
        }
    }

    private static void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    private static List<List<Integer>> getDisjointCycles(int[] balls) {
        List<List<Integer>> result = new ArrayList<>();
        Set<Integer> seen = new HashSet<>();

        for (int i = 0; i < 8; i++) {
            // Skip over balls that already belong to an existing cycle
            if (seen.contains(i)) {
                continue;
            }

            // Create a new cycle
            List<Integer> cycle = new ArrayList<>();
            cycle.add(i);
            seen.add(i);
            int next = i;

            while (balls[next] != i) {
                next = balls[next];
                cycle.add(next);
                seen.add(next);
            }

            result.add(cycle);
        }

        return result;
    }

    private static int[] makeResult(List<List<Integer>> disjointCycles, int K) {
        int[] result = new int[8];

        for (List<Integer> cycle : disjointCycles) {
            if (cycle.size() == 1) {
                result[cycle.get(0)] = cycle.get(0);
                continue;
            }

            int steps = K % cycle.size();

            for (int i = 0; i < cycle.size(); i++) {
                int finalIndex = cycle.get(i);
                int originalIndex = cycle.get((i + steps) % cycle.size());
                result[finalIndex] = originalIndex;
            }
        }

        return result;
    }
}

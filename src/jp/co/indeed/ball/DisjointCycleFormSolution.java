package jp.co.indeed.ball;

import static java.util.stream.Collectors.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class DisjointCycleFormSolution {

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
            List<List<Integer>> disjointCyclesPowerK = new ArrayList<>();
            for (List<Integer> disjointCycle : getDisjointCycles(balls)) {
                disjointCyclesPowerK.addAll(power(disjointCycle, K));
            }

            // Build result
            int[] result = makeResult(disjointCyclesPowerK);
            for (int i = 0; i < 8; i++) {
                result[i]++;
            }

            System.out.println(Arrays.stream(result)
                .boxed()
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

    private static List<List<Integer>> power(List<Integer> disjointCycle, int K) {
        List<List<Integer>> result = new ArrayList<>();
        int cycleLength = disjointCycle.size();
        int power = K % cycleLength;

        // Identity permutation
        if (power == 0) {
            for (Integer element : disjointCycle) {
                result.add(Collections.singletonList(element));
            }
            return result;
        }

        if (power == 1) {
            return Collections.singletonList(disjointCycle);
        }

        // Find disjoint cycles within disjoint cycle
        Set<Integer> seen = new HashSet<>();
        for (int i = 0; i < cycleLength; i++) {
            int start = disjointCycle.get(i);
            if (seen.contains(start)) {
                continue;
            }

            List<Integer> cycle = new ArrayList<>();
            cycle.add(start);
            seen.add(start);
            int index = (i + power) % cycleLength;

            while (disjointCycle.get(index) != start) {
                cycle.add(disjointCycle.get(index));
                seen.add(disjointCycle.get(index));
                index = (index + power) % cycleLength;
            }

            result.add(cycle);
        }

        return result;
    }

    private static int[] makeResult(List<List<Integer>> disjointCyclesPowerK) {
        int[] result = new int[8];

        for (List<Integer> cycle : disjointCyclesPowerK) {
            if (cycle.size() == 1) {
                result[cycle.get(0)] = cycle.get(0);
                continue;
            }

            int start = cycle.get(0);
            for (int i = 1; i < cycle.size(); i++) {
                result[cycle.get(i - 1)] = cycle.get(i);
            }

            result[cycle.get(cycle.size() - 1)] = start;
        }

        return result;
    }
}

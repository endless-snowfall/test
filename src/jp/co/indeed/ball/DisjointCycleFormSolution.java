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
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] perm = { 0, 1, 2, 3, 4, 5, 6, 7 };

            for (int i = 0; i < n; i++) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                swap(perm, a - 1, b - 1);
            }

            // Disjoint cycle form
            List<List<Integer>> disjointCycles = getDisjointCycles(perm);
            List<List<Integer>> disjointCyclesPowerK = new ArrayList<>();

            for (List<Integer> disjointCycle : disjointCycles) {
                disjointCyclesPowerK.addAll(power(disjointCycle, k));
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

    private static void swap(int[] perm, int a, int b) {
        int temp = perm[a];
        perm[a] = perm[b];
        perm[b] = temp;
    }

    private static List<List<Integer>> getDisjointCycles(int[] perm) {
        List<List<Integer>> result = new ArrayList<>();
        Set<Integer> seen = new HashSet<>();

        for (int i = 0; i < 8; i++) {
            int start = perm[i];
            if (seen.contains(start)) {
                continue;
            }

            List<Integer> cycle = new ArrayList<>();
            cycle.add(start);
            seen.add(start);
            int next = start;

            while (perm[next] != start) {
                next = perm[next];
                cycle.add(next);
                seen.add(next);
            }

            result.add(cycle);
        }

        return result;
    }

    private static List<List<Integer>> power(List<Integer> disjointCycle, int k) {
        List<List<Integer>> result = new ArrayList<>();
        int cycleLength = disjointCycle.size();
        int power = k % cycleLength;

        if (power == 0) {
            for (Integer element : disjointCycle) {
                result.add(Collections.singletonList(element));
            }
            return result;
        }

        if (power == 1) {
            return Collections.singletonList(disjointCycle);
        }

        Set<Integer> seen = new HashSet<>();
        for (int i = 0; i < disjointCycle.size(); i++) {
            int start = disjointCycle.get(i);
            if (seen.contains(start)) {
                continue;
            }

            List<Integer> cycle = new ArrayList<>();
            cycle.add(start);
            seen.add(start);
            int index = (i + power) % disjointCycle.size();

            while (disjointCycle.get(index) != start) {
                cycle.add(disjointCycle.get(index));
                seen.add(disjointCycle.get(index));
                index = (index + power) % disjointCycle.size();
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

package jp.co.indeed.sum.of.products;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import com.google.common.collect.Iterables;

public class PermutationSolution {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int length = sc.nextInt();
            int[] array = new int[length];
            Map<Integer, Integer> assigned = new HashMap<>();
            List<Integer> unassigned = new LinkedList<>();

            // Track assigned and unassigned numbers
            for (int i = 0; i < length; i++) {
                int number = sc.nextInt();
                int location = sc.nextInt();

                if (location != -1) {
                    assigned.put(location - 1, number);
                } else {
                    unassigned.add(number);
                }
            }

            // Fill array
            for (int i = 0; i < length; i++) {
                if (assigned.keySet().contains(i)) {
                    array[i] = assigned.get(i);
                } else {
                    array[i] = unassigned.remove(0);
                }
            }

            System.out.println(Arrays.toString(array));
            System.out.println(assigned.keySet());

            Set<Integer> result = new HashSet<>(1);
            result.add(Integer.MIN_VALUE);
            permute(array, 0, assigned.keySet(), result);
            System.out.println(Iterables.getOnlyElement(result));
        }
    }

    private static void permute(int[] array, int index, Set<Integer> assignedIndices, Set<Integer> result) {
        for (int i = index; i < array.length; i++) {
            if (assignedIndices.contains(i)) {
                continue;
            }
            swap(array, i, index);
            permute(array, index + 1, assignedIndices, result);
            swap(array, index, i);
        }

        if (index == array.length - 1) {
            System.out.println("candidate: " + Arrays.toString(array));
            int candidate = computeSumOfProducts(array);
            System.out.println(candidate);
            if (candidate > Iterables.getOnlyElement(result)) {
                result.clear();
                result.add(candidate);
            }
        }
    }

    private static int computeSumOfProducts(int[] array) {
        int result = 0;
        for (int i = 0; i < array.length - 1; i++) {
            result += (array[i] * array[i + 1]);
        }
        return result;
    }

    private static void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
}

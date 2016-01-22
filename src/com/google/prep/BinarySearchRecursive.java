package com.google.prep;

public class BinarySearchRecursive {

    public int binarySearch(int[] input, int target) {
        return binarySearchHelper(input, target, 0, input.length - 1);
    }

    private int binarySearchHelper(int[] input, int target, int start, int end) {
        if (start > end) {
            return -1;
        }

        int mid = (start + end) / 2;
        if (input[mid] < target) {
            return binarySearchHelper(input, target, mid + 1, end);
        } else if (input[mid] > target) {
            return binarySearchHelper(input, target, start, end - 1);
        }

        return target == input[mid] ? target : -1;
    }
}

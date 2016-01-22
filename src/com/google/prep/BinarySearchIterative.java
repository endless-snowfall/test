package com.google.prep;

public class BinarySearchIterative {

    public int binarySearch(int[] input, int target) {
        int start = 0;
        int end = input.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;
            if (input[mid] == target) {
                return mid;
            } else if (input[mid] > target) {
                end = mid - 1;
                continue;
            }
            start = mid + 1;
        }

        return -1;
    }
}

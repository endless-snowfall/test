package concurrency.array.sum;

import java.util.Arrays;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ParallelArraySum implements ArraySumInterace {

    @Override
    public int sum(int[] input) {
        return Arrays.stream(input).parallel().sum();
    }
}

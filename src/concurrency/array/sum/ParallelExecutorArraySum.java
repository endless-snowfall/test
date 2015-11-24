package concurrency.array.sum;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.IntStream;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ParallelExecutorArraySum implements ArraySumInterace {

    private Integer numThreads;

    @Override
    public int sum(int[] input) {
        ExecutorService service = Executors.newFixedThreadPool(numThreads);
        int rangePerThread = Math.max(input.length / numThreads, input.length % numThreads);
        List<Future<Integer>> futures = new ArrayList<>();

        for (int i = 0; i < numThreads; i++) {
            int startIndex = i * rangePerThread;
            if (startIndex > input.length) {
                break;
            }

            int endIndex = Math.min(startIndex + rangePerThread, input.length);
            futures.add(service.submit(() -> sumSegment(input, startIndex, endIndex)));
        }

        return futures.stream().mapToInt(future -> getOrDefault(future, 0)).sum();
    }

    private int getOrDefault(Future<Integer> future, int defaultValue) {
        try {
            return future.get();
        } catch (Exception e) {
            return defaultValue;
        }
    }

    private Integer sumSegment(int[] input, int startIndexInclusive, int endIndexExclusive) {
        return IntStream.range(startIndexInclusive, endIndexExclusive).map(index -> input[index]).sum();
    }
}

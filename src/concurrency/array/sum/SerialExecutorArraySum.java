package concurrency.array.sum;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.IntStream;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

@RequiredArgsConstructor
public class SerialExecutorArraySum implements ArraySumInterace {

    private ExecutorService service = Executors.newSingleThreadExecutor();

    @Override
    @SneakyThrows
    public int sum(int[] input) {
        Callable<Integer> sumCallable = new SumCallable(input, 0, input.length - 1);
        Future<Integer> futureSum = service.submit(sumCallable);
        return futureSum.get();
    }

    @AllArgsConstructor
    private class SumCallable implements Callable<Integer> {

        private int[] input;
        private int startInclusive;
        private int endInclusive;

        @Override
        public Integer call() {
            return IntStream.rangeClosed(startInclusive, endInclusive).map(i -> input[i]).sum();
        }
    }
}

package concurrency.array.sum;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import common.TestBase;
import common.TestUtils;
import concurrency.array.sum.ArraySumInterace;
import concurrency.array.sum.ParallelArraySum;

public class ArraySumTest extends TestBase {

    private ArraySumInterace solution;

    @Before
    public void before() {
        solution = new ParallelArraySum();
    }

    @Test
    public void test1() {
        int[] input = generateRandomInput(1, 100);
        assertEquals(input[0], solution.sum(input));
    }

    @Test
    public void test2() {
        int[] input = generateRandomInput(100, 100);
        assertEquals(serializedSum(input), solution.sum(input));
    }

    @Test
    public void test3() {
        int[] input = generateRandomInput(10000000, 100000);
        assertEquals(serializedSum(input), solution.sum(input));
    }

    private int[] generateRandomInput(int numElements, int elementBoundExclusive) {
        int[] result = new int[numElements];
        for (int i = 0; i < numElements; i++) {
            result[i] = TestUtils.getRandomIntegerExclusive(elementBoundExclusive);
        }
        return result;
    }

    private int serializedSum(int[] input) {
        return Arrays.stream(input).sum();
    }
}

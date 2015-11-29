package jp.co.indeed.sum.of.products;

import static common.TestUtils.*;

import org.junit.Test;

public class PermutationSolutionTest {

    @Test
    public void test1() {
        System.setIn(mockInputStreamFromFile(
            "/Users/anthony/Documents/workspace/test/tst/jp/co/indeed/sum/of/products/test1.in"));
        PermutationSolution.main(new String[] {});
    } // 4600

    @Test
    public void test2() {
        System.setIn(mockInputStreamFromFile(
            "/Users/anthony/Documents/workspace/test/tst/jp/co/indeed/sum/of/products/test2.in"));
        PermutationSolution.main(new String[] {});
    } // 6300

    @Test
    public void test3() {
        System.setIn(mockInputStreamFromFile(
            "/Users/anthony/Documents/workspace/test/tst/jp/co/indeed/sum/of/products/test3.in"));
        PermutationSolution.main(new String[] {});
    } // 0

    @Test
    public void test4() {
        System.setIn(mockInputStreamFromFile(
            "/Users/anthony/Documents/workspace/test/tst/jp/co/indeed/sum/of/products/test4.in"));
        PermutationSolution.main(new String[] {});
    } // 1342

    @Test
    public void test5() {
        System.setIn(mockInputStreamFromFile(
            "/Users/anthony/Documents/workspace/test/tst/jp/co/indeed/sum/of/products/test5.in"));
        PermutationSolution.main(new String[] {});
    } // 504

    @Test
    public void test6() {
        System.setIn(mockInputStreamFromFile(
            "/Users/anthony/Documents/workspace/test/tst/jp/co/indeed/sum/of/products/test6.in"));
        PermutationSolution.main(new String[] {});
    } // 8000
}

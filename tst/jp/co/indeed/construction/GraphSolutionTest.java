package jp.co.indeed.construction;

import static common.TestUtils.*;

import org.junit.Test;

public class GraphSolutionTest {

    @Test
    public void test1() {
        System.setIn(mockInputStreamFromFile(
            "/Users/anthony/Documents/workspace/test/tst/jp/co/indeed/construction/test1.in"));
        GraphSolution.main(new String[] {});
        // YES 1
        // NO
        // YES 3
        // NO
    }

    @Test
    public void test2() {
        System.setIn(mockInputStreamFromFile(
            "/Users/anthony/Documents/workspace/test/tst/jp/co/indeed/construction/test2.in"));
        GraphSolution.main(new String[] {});
        // YES 2
        // YES 1
        // NO
        // YES 3
    }

    @Test
    public void test3() {
        System.setIn(mockInputStreamFromFile(
            "/Users/anthony/Documents/workspace/test/tst/jp/co/indeed/construction/test3.in"));
        GraphSolution.main(new String[] {});
        // YES 4
        // YES 11
        // YES 8
        // YES 9
        // YES 13
        // YES 18
        // YES 20
        // YES 16
        // YES 24
        // YES 14
    }
}

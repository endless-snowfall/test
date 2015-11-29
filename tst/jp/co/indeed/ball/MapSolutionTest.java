package jp.co.indeed.ball;

import static common.TestUtils.*;

import org.junit.Test;

public class MapSolutionTest {

    @Test
    public void test1() {
        System.setIn(mockInputStreamFromFile(
            "/Users/anthony/Documents/workspace/test/tst/jp/co/indeed/ball/test1.in"));
        MapSolution.main(new String[] {});
        // 1 4 2 3 5 6 7 8
    }

    @Test
    public void test2() {
        System.setIn(mockInputStreamFromFile(
            "/Users/anthony/Documents/workspace/test/tst/jp/co/indeed/ball/test2.in"));
        MapSolution.main(new String[] {});
        // 1 8 3 4 5 2 7 6
    }
}

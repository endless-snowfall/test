package jp.co.indeed.rotation;

import static common.TestUtils.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class RotateIndexSolutionTest {

    @Test
    public void test1() {
        System.setIn(mockInputStream(
            "5 abcde 2 2 4 1 1 5 2"));
        RotateIndexSolution.main(new String[] {});
        // ceadb
    }

    @Test
    public void test2() {
        System.setIn(mockInputStream(
            "5 abcde 1 2 4 1"));
        RotateIndexSolution.main(new String[] {});
        // adbce
    }

    @Test
    public void test3() {
        System.setIn(mockInputStreamFromFile(
            "/Users/anthony/Documents/workspace/test/tst/jp/co/indeed/rotation/test1.in"));
        RotateIndexSolution.main(new String[] {});
        // ceadb
    }

    @Test
    public void test4() {
        System.setIn(mockInputStreamFromFile(
            "/Users/anthony/Documents/workspace/test/tst/jp/co/indeed/rotation/test2.in"));
        RotateIndexSolution.main(new String[] {});
        // vkidskofbk
    }

    @Test
    public void test5() {
        System.setIn(mockInputStream(
            "5 abcde 1 1 5 0"));
        RotateIndexSolution.main(new String[] {});
        // adbce
    }

    @Test
    public void test6() {
        assertTrue("anthony".substring(7, 7).isEmpty());
    }
}

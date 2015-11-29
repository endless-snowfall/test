package jp.co.indeed.rotation;

import static common.TestUtils.*;

import org.junit.Test;

public class DuplicateRotationSubstringSolutionTest {

    @Test
    public void test1() {
        System.setIn(mockInputStream(
            "5 abcde 2 2 4 1 1 5 2"));
        DuplicateRotationSubstringSolution.main(new String[] {});
        // ceadb
    }

    @Test
    public void test2() {
        System.setIn(mockInputStream(
            "5 abcde 1 2 4 1"));
        DuplicateRotationSubstringSolution.main(new String[] {});
        // adbce
    }

    @Test
    public void test3() {
        System.setIn(mockInputStreamFromFile(
            "/Users/anthony/Documents/workspace/test/tst/jp/co/indeed/rotation/test1.in"));
        DuplicateRotationSubstringSolution.main(new String[] {});
        // ceadb
    }

    @Test
    public void test4() {
        System.setIn(mockInputStreamFromFile(
            "/Users/anthony/Documents/workspace/test/tst/jp/co/indeed/rotation/test2.in"));
        DuplicateRotationSubstringSolution.main(new String[] {});
        // vkidskofbk
    }

    @Test
    public void test5() {
        System.setIn(mockInputStream(
            "5 abcde 1 1 5 0"));
        DuplicateRotationSubstringSolution.main(new String[] {});
        // adbce
    }

    @Test
    public void test6() {
        System.setIn(mockInputStream(
            "9 abcdefghi 1 1 9 3"));
        DuplicateRotationSubstringSolution.main(new String[] {});
        // ghiabcdef
    }
}

package common;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;

import lombok.SneakyThrows;

public class TestUtils {

    private static final Random random = new Random();

    public static int getRandomIntegerExclusive(int exclusivebound) {
        return random.nextInt(exclusivebound);
    }

    public static InputStream mockInputStream(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }

    public static InputStream mockInputStreamFromFile(String fullPath) {
        return new ByteArrayInputStream(getStringFromFile(fullPath).getBytes());
    }

    @SneakyThrows
    public static String getStringFromFile(String fullPath) {
        return new String(Files.readAllBytes(Paths.get(fullPath)));
    }

    public static <T> void assertListsEqualUnordered(List<T> expected, List<T> actual) {
        assertTrue(String.format("Lists expected=[%s] and actual=[%s] are not the same size!", expected, actual),
            expected.size() == actual.size());
        assertFalse(String.format("Lists are not equal (unordered)! List1=[%s], List2=[%s]", expected, actual),
            expected.stream()
                .filter(i -> !actual.contains(i))
                .findAny()
                .isPresent());
    }
}

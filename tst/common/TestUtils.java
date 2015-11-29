package common;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
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
}

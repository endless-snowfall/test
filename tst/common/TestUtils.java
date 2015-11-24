package common;

import java.util.Random;

public class TestUtils {

    private static final Random random = new Random();

    public static int getRandomIntegerExclusive(int exclusivebound) {
        return random.nextInt(exclusivebound);
    }
}

package domain;

public class ChickenLimitChecker {
    private static final int CHICKEN_LIMIT = 99;

    public static boolean isLimit(int chickenSize) {
        return chickenSize > CHICKEN_LIMIT;
    }
}

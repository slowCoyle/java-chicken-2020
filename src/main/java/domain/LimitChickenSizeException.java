package domain;

public class LimitChickenSizeException extends IllegalArgumentException {
    private static final String LIMIT_CHICKEND_SIZE_EXCEPTION_MESSAGE = "메뉴의 치킨 사이즈가 초과되었습니다.";

    public LimitChickenSizeException() {
        super(LIMIT_CHICKEND_SIZE_EXCEPTION_MESSAGE);
    }
}

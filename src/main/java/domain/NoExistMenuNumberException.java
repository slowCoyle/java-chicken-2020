package domain;

public class NoExistMenuNumberException extends IllegalArgumentException {
    public NoExistMenuNumberException() {
        super("잘못된 메뉴 번호가 들어왔습니다.");
    }
}

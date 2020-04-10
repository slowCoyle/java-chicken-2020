package domain;

public class NoExistTableNumberException extends IllegalArgumentException {
    public NoExistTableNumberException() {
        super("잘못된 테이블 넘버가 들어왔습니다.");
    }
}

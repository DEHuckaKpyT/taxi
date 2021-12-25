package study.taxi.api.exception;

public class UserHasEmptyFieldsException extends RuntimeException{

    public UserHasEmptyFieldsException(String message) {
        super(message);
    }
}

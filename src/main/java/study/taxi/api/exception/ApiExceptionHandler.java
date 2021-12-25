package study.taxi.api.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import study.taxi.api.dto.ErrorDto;

import static org.springframework.http.HttpStatus.PRECONDITION_FAILED;

@RestControllerAdvice
public class ApiExceptionHandler {

    @ResponseStatus(PRECONDITION_FAILED)
    @ExceptionHandler(value = {UserHasEmptyFieldsException.class})
    public ErrorDto preconditionFailed(RuntimeException exception) {
        return new ErrorDto(exception.getMessage());
    }
}

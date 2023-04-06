package aman.dubey.backend.app.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ExceptionHandling  extends RuntimeException{


    private static final long serialVersionUID = 1L;

    public ExceptionHandling(String message) {
        super(message);
    }
}

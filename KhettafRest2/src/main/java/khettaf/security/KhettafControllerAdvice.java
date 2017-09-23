package khettaf.security;

import khettaf.exceptions.ConnectedUserNotFound;
import khettaf.exceptions.KhettafNotFoundException;
import org.springframework.hateoas.VndErrors;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by Me on 23/09/2017.
 */
@ControllerAdvice
public class KhettafControllerAdvice {

    @ResponseBody
    @ExceptionHandler(KhettafNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    VndErrors userNotFoundExceptionHandler(ConnectedUserNotFound ex) {
        return new VndErrors("error", ex.getMessage());
    }
}

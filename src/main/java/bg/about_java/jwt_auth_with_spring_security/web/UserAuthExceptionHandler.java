package bg.about_java.jwt_auth_with_spring_security.web;

import bg.about_java.jwt_auth_with_spring_security.service.exeptions.UserAuthException;
import bg.about_java.jwt_auth_with_spring_security.web.errors.UserAuthError;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class UserAuthExceptionHandler {

    @ExceptionHandler(UserAuthException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public UserAuthError handleUserRegistrationError(UserAuthException exception) {
        return new UserAuthError(exception.getMessage(), exception.getErrors(), HttpStatus.BAD_REQUEST.value());
    }

}

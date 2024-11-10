package bg.about_java.jwt_auth_with_spring_security.service.exeptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Getter
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UserRegistrationException extends RuntimeException {

    private final String[] errors;

    public UserRegistrationException(String message, String... errors) {
        super(message);
        this.errors = errors;
    }
}

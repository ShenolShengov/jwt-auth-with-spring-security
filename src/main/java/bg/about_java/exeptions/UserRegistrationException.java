package bg.about_java.exeptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Getter
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UserRegistrationException extends RuntimeException {

    private final String[] violations;

    public UserRegistrationException(String message, String... violations) {
        super(message);
        this.violations = violations;
    }
}

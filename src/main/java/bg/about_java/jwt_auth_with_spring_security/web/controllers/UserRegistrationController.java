package bg.about_java.jwt_auth_with_spring_security.web.controllers;

import bg.about_java.jwt_auth_with_spring_security.service.exeptions.UserRegistrationException;
import bg.about_java.jwt_auth_with_spring_security.domain.dto.UserRegisterDTO;
import bg.about_java.jwt_auth_with_spring_security.utils.BindingResultUtils;
import bg.about_java.jwt_auth_with_spring_security.web.errors.UserRegistrationError;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserRegistrationController {

    @PostMapping("/register")
    public ResponseEntity<UserRegisterDTO> register(@RequestBody @Valid UserRegisterDTO userRegisterDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new UserRegistrationException("Can't register user. See errors.", BindingResultUtils.errorsMessages(bindingResult));
        }

        return null;
    }

    @ExceptionHandler(UserRegistrationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public UserRegistrationError handleUserRegistrationError(UserRegistrationException exception) {
        return new UserRegistrationError(exception.getMessage(), exception.getErrors(), HttpStatus.BAD_REQUEST.value());
    }
}

package bg.about_java.jwt_auth_with_spring_security.web.controllers;

import bg.about_java.jwt_auth_with_spring_security.domain.dto.UserRegisterDTO;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserRegistrationController {

    @PostMapping("/register")
    public ResponseEntity<UserRegisterDTO> register(@RequestBody @Valid UserRegisterDTO userRegisterDTO,
                                                    BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {

        }
        return null;
    }
}

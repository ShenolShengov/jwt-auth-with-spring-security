package bg.about_java.jwt_auth_with_spring_security.web.controllers;

import bg.about_java.jwt_auth_with_spring_security.domain.dto.UserRegisterDTO;
import bg.about_java.jwt_auth_with_spring_security.service.UserService;
import bg.about_java.jwt_auth_with_spring_security.service.exeptions.UserAuthException;
import bg.about_java.jwt_auth_with_spring_security.utils.BindingResultUtils;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserRegistrationController {

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody @Valid UserRegisterDTO userRegisterDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new UserAuthException("Can't register user. See errors.", BindingResultUtils.errorsMessages(bindingResult));
        }
        userService.register(userRegisterDTO);
        return ResponseEntity.ok("Successfully register user %s".formatted(userRegisterDTO.getUsername()));
    }
}


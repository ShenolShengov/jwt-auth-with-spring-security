package bg.about_java.jwt_auth_with_spring_security.web.controllers;

import bg.about_java.jwt_auth_with_spring_security.domain.dto.JwtDTO;
import bg.about_java.jwt_auth_with_spring_security.domain.dto.UserLoginDTO;
import bg.about_java.jwt_auth_with_spring_security.service.JwtService;
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
public class UserLoginController {

    private final JwtService jwtService;

    @PostMapping("/login")
    public ResponseEntity<JwtDTO> login(@RequestBody @Valid UserLoginDTO userLoginDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new UserAuthException("Cant' login. See errors", BindingResultUtils.errorsMessages(bindingResult));
        }
        return ResponseEntity.ok(jwtService.generateToken(userLoginDTO.getUsername()));
    }
}

package bg.about_java.jwt_auth_with_spring_security.service;


import bg.about_java.jwt_auth_with_spring_security.domain.dto.JwtDTO;
import jakarta.servlet.http.HttpServletRequest;

import java.util.Optional;

public interface JwtService {

    JwtDTO generateToken(String username);

    Optional<String> extractJwt(HttpServletRequest request);

    boolean isValid(String jwt);

    Optional<String> extractSubject(String jwt);

}

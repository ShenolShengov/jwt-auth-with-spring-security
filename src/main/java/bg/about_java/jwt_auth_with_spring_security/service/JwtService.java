package bg.about_java.jwt_auth_with_spring_security.service;


import bg.about_java.jwt_auth_with_spring_security.domain.dto.JwtDTO;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;

import java.util.Optional;
import java.util.function.Function;

public interface JwtService {

    JwtDTO generateToken(String username);

    Optional<String> extractJwt(HttpServletRequest request);

    boolean isValid(String jwt);
    <T> Optional<T> extractClaim(String jwt, Function<Claims, T> extractFunction);

}

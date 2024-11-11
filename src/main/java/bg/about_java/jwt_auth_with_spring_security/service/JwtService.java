package bg.about_java.jwt_auth_with_spring_security.service;


import bg.about_java.jwt_auth_with_spring_security.domain.dto.JwtDTO;

public interface JwtService {

    JwtDTO generateToken(String username);

}

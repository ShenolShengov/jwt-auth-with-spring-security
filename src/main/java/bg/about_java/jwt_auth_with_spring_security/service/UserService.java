package bg.about_java.jwt_auth_with_spring_security.service;

import bg.about_java.jwt_auth_with_spring_security.domain.dto.UserRegisterDTO;
import bg.about_java.jwt_auth_with_spring_security.domain.entity.UserEntity;

public interface UserService {

    UserEntity register(UserRegisterDTO userRegisterDTO);
}

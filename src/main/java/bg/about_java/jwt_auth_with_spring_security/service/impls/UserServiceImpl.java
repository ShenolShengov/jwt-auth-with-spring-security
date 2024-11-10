package bg.about_java.jwt_auth_with_spring_security.service.impls;

import bg.about_java.jwt_auth_with_spring_security.domain.dto.UserRegisterDTO;
import bg.about_java.jwt_auth_with_spring_security.domain.entity.UserEntity;
import bg.about_java.jwt_auth_with_spring_security.repository.UserRepository;
import bg.about_java.jwt_auth_with_spring_security.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Override
    public UserEntity register(UserRegisterDTO userRegisterDTO) {
        UserEntity toRegister = modelMapper.map(userRegisterDTO, UserEntity.class);
        return userRepository.save(toRegister);
    }
}

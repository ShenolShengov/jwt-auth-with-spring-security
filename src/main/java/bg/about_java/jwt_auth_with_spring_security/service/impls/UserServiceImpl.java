package bg.about_java.jwt_auth_with_spring_security.service.impls;

import bg.about_java.jwt_auth_with_spring_security.domain.dto.UserRegisterDTO;
import bg.about_java.jwt_auth_with_spring_security.domain.entity.UserEntity;
import bg.about_java.jwt_auth_with_spring_security.repository.UserRepository;
import bg.about_java.jwt_auth_with_spring_security.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserEntity register(UserRegisterDTO userRegisterDTO) {
        UserEntity toRegister = modelMapper.map(userRegisterDTO, UserEntity.class);
        toRegister.setPassword(passwordEncoder.encode(toRegister.getPassword()));
        return userRepository.save(toRegister);
    }
}

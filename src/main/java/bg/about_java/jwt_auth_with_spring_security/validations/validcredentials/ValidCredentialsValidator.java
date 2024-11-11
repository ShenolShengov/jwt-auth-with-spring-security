package bg.about_java.jwt_auth_with_spring_security.validations.validcredentials;

import bg.about_java.jwt_auth_with_spring_security.domain.dto.UserLoginDTO;
import bg.about_java.jwt_auth_with_spring_security.domain.entity.UserEntity;
import bg.about_java.jwt_auth_with_spring_security.repository.UserRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

@RequiredArgsConstructor
public class ValidCredentialsValidator implements ConstraintValidator<ValidCredentials, UserLoginDTO> {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public boolean isValid(UserLoginDTO userLoginDTO, ConstraintValidatorContext context) {
        if (userLoginDTO == null) return false;
        Optional<UserEntity> foundedUser = userRepository.findByUsername(userLoginDTO.getUsername());
        return foundedUser.isPresent() &&
               passwordEncoder.matches(userLoginDTO.getPassword(), foundedUser.get().getPassword());
    }
}

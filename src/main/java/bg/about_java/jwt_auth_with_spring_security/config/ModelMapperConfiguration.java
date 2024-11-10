package bg.about_java.jwt_auth_with_spring_security.config;

import bg.about_java.jwt_auth_with_spring_security.domain.dto.UserRegisterDTO;
import bg.about_java.jwt_auth_with_spring_security.domain.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.builder.ConfigurableConditionExpression;
import org.modelmapper.builder.ReferenceMapExpression;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@RequiredArgsConstructor
public class ModelMapperConfiguration {

    private final PasswordEncoder passwordEncoder;

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.typeMap(UserRegisterDTO.class, UserEntity.class)
                .addMappings(e -> encodePasswordConverter(e).map(UserRegisterDTO::getPassword, UserEntity::setPassword));
        return modelMapper;
    }

    private ReferenceMapExpression<UserRegisterDTO, UserEntity> encodePasswordConverter(ConfigurableConditionExpression<UserRegisterDTO, UserEntity> e) {
        return e.using((Converter<String, String>) mappingContext ->
                passwordEncoder.encode(mappingContext.getSource()));
    }

}

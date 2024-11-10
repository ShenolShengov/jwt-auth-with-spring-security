package bg.about_java.jwt_auth_with_spring_security.domain.dto;

import bg.about_java.jwt_auth_with_spring_security.validations.uniqueemail.UniqueEmail;
import bg.about_java.jwt_auth_with_spring_security.validations.uniqueusername.UniqueUsername;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;

@Getter
@Setter
public class UserRegisterDTO implements Serializable {

    @NotNull
    @Length(min = 5, max = 30)
    @UniqueUsername
    private String username;

    @NotNull
    @Email
    @UniqueEmail
    private String email;

    @NotNull
    @Length(min = 5, max = 30)
    private String password;
}

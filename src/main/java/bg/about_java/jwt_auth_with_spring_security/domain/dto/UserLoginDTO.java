package bg.about_java.jwt_auth_with_spring_security.domain.dto;

import bg.about_java.jwt_auth_with_spring_security.validations.validcredentials.ValidCredentials;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;

@ValidCredentials
@Getter
@Setter
public class UserLoginDTO implements Serializable {

    @NotNull
    @Length(min = 5, max = 30)
    private String username;

    @NotNull
    @Length(min = 5, max = 30)
    private String password;

}

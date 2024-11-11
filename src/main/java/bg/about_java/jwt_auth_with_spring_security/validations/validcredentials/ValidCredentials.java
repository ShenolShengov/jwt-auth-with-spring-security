package bg.about_java.jwt_auth_with_spring_security.validations.validcredentials;

import bg.about_java.jwt_auth_with_spring_security.validations.uniqueusername.UniqueUsernameValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Constraint(validatedBy = ValidCredentialsValidator.class)
public @interface ValidCredentials {


    String message() default "Invalid username or password";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}

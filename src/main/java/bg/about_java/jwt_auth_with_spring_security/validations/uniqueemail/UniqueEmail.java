package bg.about_java.jwt_auth_with_spring_security.validations.uniqueemail;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = UniqueUsernameEmail.class)
public @interface UniqueEmail {

    String message() default "Email is already occupied";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}

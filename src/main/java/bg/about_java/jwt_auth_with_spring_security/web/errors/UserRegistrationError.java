package bg.about_java.jwt_auth_with_spring_security.web.errors;

public record UserRegistrationError(String message, String[] errors, Integer status) {
}

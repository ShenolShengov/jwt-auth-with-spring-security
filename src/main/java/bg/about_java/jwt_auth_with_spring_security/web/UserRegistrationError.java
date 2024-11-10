package bg.about_java.jwt_auth_with_spring_security.web;

public record UserRegistrationError(String message, String... violations) {
}

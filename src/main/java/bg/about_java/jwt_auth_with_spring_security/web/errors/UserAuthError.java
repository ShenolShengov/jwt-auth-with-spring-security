package bg.about_java.jwt_auth_with_spring_security.web.errors;

public record UserAuthError(String message, String[] errors, Integer status) {
}

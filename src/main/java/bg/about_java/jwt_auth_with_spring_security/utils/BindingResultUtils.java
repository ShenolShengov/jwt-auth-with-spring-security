package bg.about_java.jwt_auth_with_spring_security.utils;

import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.validation.BindingResult;

public class BindingResultUtils {

    public static String[] errorsMessages(BindingResult bindingResult) {
        return bindingResult.getAllErrors()
                .stream().map(DefaultMessageSourceResolvable::getDefaultMessage).toArray(String[]::new);
    }
}

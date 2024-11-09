package bg.about_java.jwt_auth_with_spring_security.service.impls;

import bg.about_java.jwt_auth_with_spring_security.domain.entity.UserEntity;
import bg.about_java.jwt_auth_with_spring_security.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.function.Supplier;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username)
                .map(UserDetailsServiceImpl::toUserDetails)
                .orElseThrow(userNotFoundException(username));
    }

    private static UserDetails toUserDetails(UserEntity user) {
        return User.withUsername(user.getUsername())
                .password(user.getPassword())
                .authorities(toRoles(user))
                .build();
    }

    private static String[] toRoles(UserEntity user) {
        return user.getRoles().stream().map(r -> "ROLE_" + r.getName()).toArray(String[]::new);
    }

    private static Supplier<UsernameNotFoundException> userNotFoundException(String username) {
        return () -> new UsernameNotFoundException("User with username %s is not found".formatted(username));
    }
}

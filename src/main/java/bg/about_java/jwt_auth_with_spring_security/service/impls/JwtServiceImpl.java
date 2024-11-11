package bg.about_java.jwt_auth_with_spring_security.service.impls;

import bg.about_java.jwt_auth_with_spring_security.domain.dto.JwtDTO;
import bg.about_java.jwt_auth_with_spring_security.service.JwtService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.time.Duration;
import java.time.Instant;
import java.util.Base64;
import java.util.Date;

@Service
public class JwtServiceImpl implements JwtService {

    @Value("${jwt_secret}")
    private String secret;
    @Value("${jwt_expiration_time}")
    private Duration expirationTime;

    @Override
    public JwtDTO generateToken(String username) {
        Instant now = Instant.now();
        final SecretKey secretKey = generateKey(secret);
        Instant expiration = now.plus(expirationTime);
        String jwt = Jwts
                .builder()
                .signWith(secretKey)
                .subject(username)
                .issuedAt(Date.from(now))
                .expiration(Date.from(expiration))
                .compact();
        return new JwtDTO(jwt);
    }

    private static SecretKey generateKey(String secret) {
        return Keys.hmacShaKeyFor(Base64.getDecoder().decode(secret));
    }
}

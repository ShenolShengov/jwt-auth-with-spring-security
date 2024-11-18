package bg.about_java.jwt_auth_with_spring_security.service.impls;

import bg.about_java.jwt_auth_with_spring_security.domain.dto.JwtDTO;
import bg.about_java.jwt_auth_with_spring_security.service.JwtService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.time.Duration;
import java.time.Instant;
import java.util.Base64;
import java.util.Date;
import java.util.Optional;
import java.util.function.Function;

@Service
public class JwtServiceImpl implements JwtService {

    @Value("${jwt_secret}")
    private String secret;
    @Value("${jwt_expiration_time}")
    private Duration expirationTime;
    @Value("${jwt-aut-with-spring-security-app}")
    private String issuer;

    @Override
    public JwtDTO generateToken(String username) {
        Instant now = Instant.now();
        final SecretKey secretKey = generateKey(secret);
        Instant expiration = now.plus(expirationTime);
        String jwt = Jwts
                .builder()
                .signWith(secretKey)
                .subject(username)
                .issuer(issuer)
                .issuedAt(Date.from(now))
                .expiration(Date.from(expiration))
                .compact();
        return new JwtDTO(jwt);
    }

    @Override
    public Optional<String> extractJwt(HttpServletRequest request) {
        String authorization = request.getHeader("Authorization");
        if (authorization == null || !authorization.startsWith("Bearer ")) {
            return Optional.empty();
        }
        String jwt = authorization.substring(7);
        return Optional.of(jwt);
    }

    @Override
    public boolean isValid(String jwt) {
        try {
            return extractClaim(jwt, Claims::getIssuedAt)
                    .map(e -> e.before(Date.from(Instant.now())))
                    .orElse(false);
        } catch (Exception e) {
            return false;
        }
    }


    @Override
    public <T> Optional<T> extractClaim(String jwt, Function<Claims, T> extractFunction) {
        try {
            Claims claims = extractClaims(jwt);
            return Optional.of(extractFunction.apply(claims));
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    private Claims extractClaims(String jwt) {
        return Jwts.
                parser().
                verifyWith(generateKey(secret))
                .requireIssuer(issuer)
                .build()
                .parseSignedClaims(jwt)
                .getPayload();
    }

    private static SecretKey generateKey(String secret) {
        return Keys.hmacShaKeyFor(Base64.getDecoder().decode(secret));
    }
}

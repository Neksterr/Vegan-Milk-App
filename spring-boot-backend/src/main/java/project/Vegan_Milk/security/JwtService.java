package project.Vegan_Milk.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import io.jsonwebtoken.security.Keys;
import project.Vegan_Milk.account.model.entity.Account;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;
import java.util.UUID;

@Service
public class JwtService {
    @Value("${jwt.secret}")
    private String secret;
    @Value("${jwt.expiration}")
    private long expiration;

    private SecretKey signKey;

    @PostConstruct
    public void init() {
        this.signKey = Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));
    }
    public String generateToken(Account account){
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + expiration);

        return Jwts.builder()
                .issuer("vegan-milk-api")
                .subject(account.getEmail())
                .audience().add("vegan-milk-react").and()
                .issuedAt(now)
                .expiration(expiryDate)
                .id(UUID.randomUUID().toString())
                .claim("accountId", account.getId())
                .claim("username", account.getUsername())
                .claim("role", account.getAccountRole().name())
                .claim("timezone", "Europe/Sofia")
                .claim("enabled", account.isEnabled())
                .signWith(signKey)
                .compact();
    }
    public Claims extractAllClaims(String token) {
        return Jwts.parser()
                .verifyWith(signKey)
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }
    public String extractEmail(String token){
        return Jwts.parser()
                .verifyWith(signKey)
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .getSubject();
    }
    public String extractRole(String token) {
        return extractAllClaims(token).get("role", String.class);
    }

    public Long extractAccountId(String token) {
        return extractAllClaims(token).get("accountId", Long.class);
    }

        public boolean isValid(String token) {
            try {
            Jwts.parser()
                    .verifyWith(signKey)
                    .build()
                    .parseSignedClaims(token);
                return true;
            } catch (Exception e) {
                return false;
            }
        }
}

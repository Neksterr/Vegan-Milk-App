package project.Vegan_Milk.security;

import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;

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

    public String generateToken(String email){
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + expiration);

        return Jwts.builder()
                .subject(email)
                .issuedAt(now)
                .expiration(expiryDate)
                .signWith(signKey)
                .compact();
    }
    public String extractEmail(String token){
        return Jwts.parser()
                .verifyWith(signKey)
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .getSubject();
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

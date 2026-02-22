package com.project.indriver_backend_sb.utils;

import com.project.indriver_backend_sb.models.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;

@Component
public class JwtUtil {

    private final SecretKey key = Keys.hmacShaKeyFor(
            "NSFCjn4gZitjZRVKMRKUKEyqnUqiOomJVtlwCw41qqLnv6Mcvz6aIv4HSvE6UmprBH2kut8udI8aLobNLsJHwkDu1YhEx4UrPhVPKYBvGtU0Nl3xpbzFHw3iX8o07hNcvgBp1Bzb5zdLsgGL20LB8Vaj4iRaPfxdV3gTaYcNSalkaaPbON51Vz7H1QUSNxnfor560P9GcSi53Ma1OSDyA8tOoAe8Gu9DdAqjJhA7htWnKw99VcDSgfHe6s1tVxGS"
                    .getBytes(StandardCharsets.UTF_8)
    );

    public String generateToken(User user) {
        long expirationTime = 1000 * 60 * 60 * 24; // 24 hour
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + expirationTime);
        return Jwts.builder()
                .subject(user.getEmail())
                .issuedAt(now)
                .expiration(expiryDate)
                .signWith(key)
                .compact();
    }

    private Claims getClaims(String token) {
        return Jwts.parser()
                .verifyWith(key)
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    public String extractUserName(String token) {
        return getClaims(token).getSubject();
    }

    private boolean isTokenExpired(String token) {
        return getClaims(token).getExpiration().before(new Date());
    }

    public boolean isTokenValid(String token, UserDetails userDetails) {
        String username = extractUserName(token);
        return username.equals(userDetails.getUsername()) && !isTokenExpired(token);
    }

}

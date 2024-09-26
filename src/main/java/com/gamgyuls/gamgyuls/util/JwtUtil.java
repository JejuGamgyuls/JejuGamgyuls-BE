package com.gamgyuls.gamgyuls.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;

@Component
public class JwtUtil {
    private final SecretKey secretKey = Keys.hmacShaKeyFor("your-fixed-secret-key-12345678901234567890".getBytes()); // 32바이트 길이의 비밀키
    private final long EXPIRATION_TIME = 1000 * 60 * 60; // 1시간 후 만료

    // JWT 생성 로직
    public String createToken(String subject) {
        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);

        // JWT 생성
        JwtBuilder builder = Jwts.builder()
                .setSubject(subject)
                .setIssuedAt(now)
                .setExpiration(new Date(nowMillis + EXPIRATION_TIME)) // 1시간 후 만료
                .signWith(secretKey); // 적절한 크기의 키 사용

        return builder.compact();
    }

    // JWT 검증
    public boolean validateToken(String token, String username) {
        try {
            final String extractedUsername = extractUsername(token);
            return (extractedUsername.equals(username) && !isTokenExpired(token));
        } catch (Exception e) {
            throw new RuntimeException("Invalid token: " + e.getMessage());
        }
    }

    // 사용자 이름 추출
    public String extractUsername(String token) {
//        System.out.println(extractAllClaims(token).getSubject());
        return extractAllClaims(token).getSubject();
    }

    // 클레임 추출
    private Claims extractAllClaims(String token) {
        try {
            return Jwts.parserBuilder()
                    .setSigningKey(secretKey) // SecretKey 객체를 직접 사용
                    .build()
                    .parseClaimsJws(token)
                    .getBody();
        } catch (Exception e) {
            throw new RuntimeException("Error extracting claims: " + e.getMessage());
        }
    }

    // JWT 토큰을 디코딩하는 메서드
    public Claims decodeToken(String token) {
        if (isTokenExpired(token)) {
            throw new RuntimeException("Token has expired");
        }
        return extractAllClaims(token);
    }

    // 토큰 만료 확인
    private boolean isTokenExpired(String token) {
        return extractAllClaims(token).getExpiration().before(new Date());
    }
}
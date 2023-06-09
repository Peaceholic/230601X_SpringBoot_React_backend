package com.hello.proto.security;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class TokenProvider {

	// JWT 생성 및 검증을 위한 키
	private static final String SECURITY_KEY = "JwtSecureOriginalKeyChainWordXXXXJwtSecureOriginalKeyChainWordXXXXJwtSecureOriginalKeyChainWordXXXX";

	// JWT 생성
	public String createToken(String userEmail) {

		// 만료날짜 현재일 + 1시간 설정
		Date expireTime = Date.from(Instant.now().plus(1, ChronoUnit.HOURS));

		// JWT 생성
		return Jwts.builder()
				// 암호화 알고리즘, 키
				.signWith(SignatureAlgorithm.HS512, SECURITY_KEY)
				// JWT 제목
				.setSubject(userEmail)
				// JWT 생성일
				.setIssuedAt(new Date())
				// JWT 만료일
				.setExpiration(expireTime)
				// 생성
				.compact();
	}

	// JWT 검증
	public String validateToken(String token) {
		// 받은 Token을 키를 사용해서 복호화
		Claims claims = Jwts.parser().setSigningKey(SECURITY_KEY).parseClaimsJws(token).getBody();
		// 복호화된 Token의 payload에서 제목을 가져옴
		return claims.getSubject();
	}
}

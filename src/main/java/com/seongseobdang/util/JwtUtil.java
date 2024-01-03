package com.seongseobdang.util;

import java.io.UnsupportedEncodingException;
import java.util.Date;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtUtil {
	
	private static final String SALT = "SEONGSEOBDANG";
	
	//token 생성
	public String createToken(String key, String value) throws UnsupportedEncodingException {
		
		Long expiredTime = 1000 * 60L * 60L * 1L;
		
		return Jwts.builder()
				.setHeaderParam("alg", "HS256")
				.setHeaderParam("typ", "JWT") //��� �Ϸ�
				.claim(key, value)
				.setExpiration(new Date(System.currentTimeMillis()+expiredTime)) //���̷ε� �Ϸ�
				.signWith(SignatureAlgorithm.HS256, SALT.getBytes("UTF-8")) //����Ϸ�
				.compact();
	}
	
	//token 검사
	public void valid(String token) throws Exception {
		 
		Jwts.parser().setSigningKey(SALT.getBytes("UTF-8")).parseClaimsJws(token);
			
		
	}
}

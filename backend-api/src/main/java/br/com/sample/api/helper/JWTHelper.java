package br.com.sample.api.helper;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JWTHelper {

	private static final String AUTH_KEY = "c2VjcmV0X2tleQ==";
	private static final Long SECONDS_TO_EXPIRES = 86400L;
	
	public String build(String subject){
		return build(subject, LocalDateTime.now().plusSeconds(SECONDS_TO_EXPIRES ));
	}
	
    public String build(String subject, LocalDateTime expiration) {
        return Jwts.builder().setHeaderParam("type", "JWT")
                .setSubject(subject)
                .setExpiration(Date.from(expiration.toInstant(ZoneOffset.UTC)))
                .signWith(SignatureAlgorithm.HS512, AUTH_KEY)
                .compact();
    }	
    
    public Claims parse(String token) {
    	System.out.println(token);
        return Jwts.parser()
                .setSigningKey(AUTH_KEY)
                .parseClaimsJws(token)
                .getBody();
    }
	
}

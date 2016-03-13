package br.com.sample.api.helper;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import io.jsonwebtoken.Claims;

public class JWTHelperTest {

    @Test
    public void parseValidToken() {
        String token = new JWTHelper().build("1");
        Claims claims = new JWTHelper().parse(token);
        assertEquals("1", claims.getSubject());
    }
    
}

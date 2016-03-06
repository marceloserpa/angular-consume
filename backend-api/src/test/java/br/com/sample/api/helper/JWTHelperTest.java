package br.com.sample.api.helper;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import io.jsonwebtoken.Claims;

public class JWTHelperTest {

    @Test
    public void parseValidToken() {
        String token = "eyJ0eXBlIjoiSldUIiwiYWxnIjoiSFM1MTIifQ.eyJzdWIiOiIxIiwiZXhwIjoxNDU3MzgwNjg1fQ.k8iYrqrcPj7wb4IhKgFkDEEhk7rqlc6fB18JHKj-BUp3BjHQuwQdtIRLauqirnNAc-9yaj_dAZD1kDJhCX3FwA";
        Claims claims = new JWTHelper().parse(token);
        assertEquals("1", claims.getSubject());
    }
    
}

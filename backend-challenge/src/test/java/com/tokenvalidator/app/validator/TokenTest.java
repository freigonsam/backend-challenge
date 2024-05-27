package com.tokenvalidator.app.validator;

import com.tokenvalidator.app.service.JwtValidation;
import com.tokenvalidator.app.utils.JWTdecrypt;
import org.apache.logging.log4j.LogManager;
import org.junit.jupiter.api.Test;

import java.util.logging.Logger;

import static org.junit.Assert.assertEquals;

public class TokenTest {


    private static final Logger log = (Logger) LogManager.getLogger(TokenTest.class);
    JwtValidation validator = new JwtValidation();
    TokenPage tokenPage = new TokenPage();
    JWTdecrypt jwtDecoder = new JWTdecrypt();

    @Test
    public void testValidJWT() {
        assertEquals("JWT Válido", validator.validateJwt(tokenPage.tokenCaso1));
        log.info("Token Válido");
    }

    @Test
    public void testInvalidJWT() {
        assertEquals("JWT inválido",validator.validateJwt(tokenPage.tokenCaso2));
        log.info("Token Inválido");
    }

    @Test
    public void testJwtComMaisDeTresReivindicacoes(){
        String payload = jwtDecoder.decryptJWT(tokenPage.tokenCaso4);
        validator.claims = jwtDecoder.getJsonObject(payload);
        if(validator.claims.size() != 3){
            log.info("false- JWT não contém somente 3 claims");
        }
    }

    @Test
    public void testJwtComNomeAlphaNumerico(){
        String payload = jwtDecoder.decryptJWT(tokenPage.tokenCaso3);
        validator.claims = jwtDecoder.getJsonObject(payload);
        String name = String.valueOf(validator.claims.get("Name"));
        if (name == null || name.isEmpty() || name.length() > 256 || validator.containsDigit(name)) {
            log.info("falso- Nome não deve conter numeros");
        }
    }
}

package com.tokenvalidator.app.utils;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.util.Base64;

public class JWTdecrypt {

    public String decryptJWT(String token) {
        String[] parts = token.split("\\.");
        if (parts.length != 3) {
            throw new IllegalArgumentException("Token JWT inválido.");
        }
        return new String(Base64.getUrlDecoder().decode(parts[1]));
    }

    public JsonObject getJsonObject(String payloadJson) {
        return new Gson().fromJson(payloadJson, JsonObject.class);
    }
}


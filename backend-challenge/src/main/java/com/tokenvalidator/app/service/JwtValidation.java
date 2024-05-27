package com.tokenvalidator.app.service;

import com.google.gson.JsonObject;
import com.tokenvalidator.app.utils.JWTdecrypt;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;

@SpringBootApplication
@Service
public class JwtValidation {

    public JsonObject claims;

    public String validateJwt(String token) {

        try {
            JWTdecrypt jwtDecoder = new JWTdecrypt();
            String payload = jwtDecoder.decryptJWT(token);
            claims = jwtDecoder.getJsonObject(payload);

            // Verifica se o JWT contém exatamente 3 claims
            if (claims.size() != 3) {
                return "false- JWT não contém exatamente 3 claims";
            }

            // Verifica a regra para a claim "Name"
            String name = String.valueOf(claims.get("Name"));
            if (name == null || name.isEmpty() || name.length() > 256 || containsDigit(name)) {
                return "falso- Nome não deve conter numeros ";
            }

            // Verifica a regra para a claim "Role"
            String role = String.valueOf(claims.get("Role"));
            if (role == null || role.matches("Admin| Member|External")) {
                return "falso- Role da reivindicação inválida";
            }


            // Verifica a regra para a claim "Seed"
            Integer seed = claims.get("Seed").getAsInt();
            if (seed == null || !isPrime(seed)) {
                return "falso- A Seed da reivindicação não é um número primo";
            }

            // Se todas as verificações passaram, retorna true
            return "JWT Válido";

        } catch (Exception e) {
            // Se houve uma exceção ao fazer o parsing do JWT, retorna false
            return "JWT inválido";
        }
    }

    // Método para verificar se uma string contém dígitos
    public boolean containsDigit(String str) {
        for (char c : str.toCharArray()) {
            if (Character.isDigit(c)) {
                return true;
            }
        }
        return false;
    }

    // Método para verificar se um número é primo
    private boolean isPrime(int n) {
        if (n <= 1) return false;
        if (n <= 3) return true;

        if (n % 2 == 0 || n % 3 == 0) return false;

        for (int i = 5; i * i <= n; i = i + 6) {
            if (n % i == 0 || n % (i + 2) == 0) return false;
        }

        return true;
    }
}
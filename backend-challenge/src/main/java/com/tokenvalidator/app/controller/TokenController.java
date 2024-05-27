package com.tokenvalidator.app.controller;
import com.tokenvalidator.app.service.JwtValidation;
import org.springframework.web.bind.annotation.RequestBody ;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/validate")
public class TokenController {
    JwtValidation jwtValidation = new JwtValidation();

    @PostMapping
    public String validate( @RequestBody String token) {

        return String.valueOf(jwtValidation.validateJwt(token));
    }
}
package com.tokenvalidator.app.validator;

import com.tokenvalidator.app.utils.JWTdecrypt;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


import static io.restassured.RestAssured.*;

public class TokenSteps {

    private TokenPage tokenPage = new TokenPage();
    private RequestSpecification requestSpecification;
    private Response response;
    private JWTdecrypt jwTdecrypt;


    @Dado("que tenho um token jwt")
    public void que_tenho_um_token_jwt(){
        requestSpecification = given()
                .contentType(ContentType.TEXT)
                .body(tokenPage.tokenCaso1)
                .log().all(true);
    }
    @Dado("que tenho um token jwt vazio")
    public void que_tenho_um_token_jwt_vazio(){
        requestSpecification = given()
                .contentType(ContentType.TEXT)
                .body(tokenPage.tokenCaso5)
                .log().all(true);
    }
    @Dado("que tenho um token jwt não autenticado")
    public void que_tenho_um_token_jwt_nao_autenticado(){
        requestSpecification = given()
                .contentType(ContentType.TEXT)
                .body(tokenPage.tokenCaso2)
                .log().all(true);
    }

    @Quando("faço uma requisição de autenticação")
    public void faço_uma_requisição_de_autenticação() {
        response =requestSpecification
                .when()
                .post("/validate");
    }

    @Então("valido se os dados da api estão autenticados")
    public void valido_se_os_dados_da_api_estão_autenticados() {
        response.then()
                .statusCode(200)
                .log().all(true);
    }

    @Então("valido se se o jwt está vazio")
    public void valido_se_se_o_jwt_está_vazio() {
      response.then()
              .statusCode(400)
              .log().all(true);
    }
    @Então("valido que os dados da api não estão autenticados")
    public void valido_que_os_dados_da_api_nao_estão_autenticados() {
        response.then()
                .statusCode(200)
                .log().all(true);
    }
}

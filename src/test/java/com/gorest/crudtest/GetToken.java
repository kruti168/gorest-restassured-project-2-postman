package com.gorest.crudtest;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class GetToken {

    public String getToken;
    @Test
    public void authToken(){
        String payload = "{\n" +
                "    \"name\": \"{{user_name}}\",\n" +
                "    \"email\": \"{{user_email}}\",\n" +
                "    \"gender\": \"male\",\n" +
                "    \"status\": \"active\"\n" +
                "}}";
        Response response = given().
               basePath("https://gorest.co.in").
                contentType("application/json").
                body(payload).
                when().post("/auth").then()
                .log().all().
                extract().response();
        getToken = response.jsonPath().getString("token");
        System.out.println("Token :" + getToken);

    }
}

package com.gorest.crudtest;

import com.gorest.model.UserPojo;
import com.gorest.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static com.gorest.utils.TestUtils.getRandomValue;
import static io.restassured.RestAssured.given;

public class UserCRUDTest extends TestBase {

    //    private String name;
    //    private String email;
    //    private String gender;
    //    private String status;
    //    private Integer id;

    @Test
    public void verifyUserCreatedSuccessfull(){
        UserPojo userPojo = new UserPojo();
        userPojo.setName("abc" + getRandomValue());
        userPojo.setEmail(getRandomValue() + "@gmail.com");
        userPojo.setGender("female");
        userPojo.setStatus("active");
        Response response = given()
                .header("Authorization","Bearer 0d4926d56e879d5d503763194ecccb62eed8b23a3de4ae6d87a3ad55c104d3ab")
                .header("Content-Type", "application/json")
                .header("Connection", "keep-alive")
                .when()
                .body(userPojo)
                .post("/users");
        response.prettyPrint();
        response.then().statusCode(201);


    }
    @Test
    public void userGetSuccessfully(){

        Response response = given()
                .header("Authorization","Bearer 0d4926d56e879d5d503763194ecccb62eed8b23a3de4ae6d87a3ad55c104d3ab")
                .header("Connection","keep-alive")
                .when()
                .get("/users/");
        response.prettyPrint();
        response.then().statusCode(200);
    }
    @Test
    public void verifyUserUpdateSuccessfully(){

        UserPojo userPojo = new UserPojo();
        userPojo.setName("kruti");
        userPojo.setEmail(getRandomValue()+ "@gmail.com");
        userPojo.setGender("female");
        userPojo.setStatus("active");
        Response response = given()
                .header("Authorization","Bearer c8fa4af5449aff5c104930482cc994318f2ae1a097c32bb596799dae3b2f6f3b")
                .header("Content-Type","application/json")
                .header("Connection","keep-alive")
                .when()
                .body(userPojo)
                .put("/users/2338775");
        response.prettyPrint();
        response.then().statusCode(200);
    }
    @Test
    public void userDeleteSuccessfully(){

        Response response =given()
                .header("Authorization","Bearer 0d4926d56e879d5d503763194ecccb62eed8b23a3de4ae6d87a3ad55c104d3ab")
                .header("Connection","keep-alive")
                .when()
                .delete("/users/2338866");
        response.prettyPrint();
        response.then().statusCode(204);

    }
}

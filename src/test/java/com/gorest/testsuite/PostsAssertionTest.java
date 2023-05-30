package com.gorest.testsuite;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.*;

public class PostsAssertionTest  {
    static ValidatableResponse response;

    @BeforeClass
    public static void inIt(){
        RestAssured.baseURI ="https://gorest.co.in";
        RestAssured.basePath = "public/v2";
        response = given()
                //     .queryParam("/users?page=1&per_page=20")
                .when()
                .get("/posts?page=1&per_page=25")
                .then()
                .statusCode(200);

    }
    //1. Verify the if the total record is 25
    @Test
    public void test001(){

        response.body("total.size()",equalTo(25));
    }
    //2. Verify the if the title of id = 2730 is equal to ”Ad ipsa coruscus ipsam eos demittocentum.”
    @Test
    public void test002(){
       response.body("findAll{it.id ==  40105}.title",hasItem("Aptus amoveo benevolentia deinde cilicium universe."));

    }
    //3. Check the single user_id in the Array list (5522)
    @Test
    public void test003(){

        response.body("id.grep()",hasItem(39297));
    }
    //4. Check the multiple ids in the ArrayList (2693, 2684,2681)
    @Test
    public void test004()
    {
        response.body("id.grep()",hasItems(39305,39304,39297));
    }

   /* 5. Verify the body of userid = 2678 is equal “Carus eaque voluptatem. Calcar
    spectaculum coniuratio. Abstergo consequatur deleo. Amiculum advenio dolorem.
    Sollers conservo adiuvo. Concedo campana capitulus. Adfectus tibi truculenter.
    Canto temptatio adimpleo. Ter degenero animus. Adeo optio crapula. Abduco et
    antiquus. Chirographum baiulus spoliatio. Suscipit fuga deleo. Comburo aequus
    cuppedia. Crur cuppedia voluptates. Argentum adduco vindico. Denique undique
    adflicto. Assentator umquam pel*/

    @Test
    public void test005(){

    response.body("findAll{it.user_id == 2329083}.body",hasItem("Cohaero at cavus. Administratio callide voluptates. Blandior conservo virga. Tunc aer vorax. Commodi vomer aeger. Clam numquam texo. Viridis aggredior anser. Utilis sollicito communis. Armarium communis considero. Vulgo asper unde. Apparatus aegre cilicium. Vulgus dapifer bardus. Supra tego demens."));
    }
}

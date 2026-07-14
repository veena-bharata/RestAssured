package com.test.api;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;

public class GetRequestTest {

    @Test
    public void testGetUsers() {
        // Switching to a robust alternative public test server
        RestAssured.baseURI = "https://dummyjson.com";

        given()
            .header("Content-Type", "application/json")
        .when()
            .get("/products/1") 
        .then()
            .statusCode(200) // Expecting a clean 200 OK
            .body("id", equalTo(1))
            .body("title", notNullValue())
            .log().all(); 
    }
}

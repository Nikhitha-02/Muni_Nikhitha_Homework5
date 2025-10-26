package com.dataart.tests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class GetUserTest extends BaseTest {

    @Test
    public void getUser() {
        Response res = given()
                .accept(ContentType.JSON)
                .when()
                .get(BASE_PATH + "/" + USERNAME)
                .then()
                .statusCode(200)
                .extract().response();

        String returnedUsername = res.path("username");
        assertThat(returnedUsername, is(USERNAME));
        
    }
}

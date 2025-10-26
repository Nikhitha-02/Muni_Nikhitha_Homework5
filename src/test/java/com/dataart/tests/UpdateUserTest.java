package com.dataart.tests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class UpdateUserTest extends BaseTest {

    @Test
    public void updateUser() {
        String updatePayload = "{\n" +
                "  \"id\": 12345,\n" +
                "  \"username\": \"" + USERNAME + "\",\n" +
                "  \"firstName\": \"MuniUpdated\",\n" +
                "  \"lastName\": \"NikhithaUpdated\",\n" +
                "  \"email\": \"muni.updated@example.com\",\n" +
                "  \"password\": \"newpassword123\",\n" +
                "  \"phone\": \"8888888888\",\n" +
                "  \"userStatus\": 1\n" +
                "}";

        given()
                .contentType(ContentType.JSON)
                .body(updatePayload)
                .when()
                .put(BASE_PATH + "/" + USERNAME)
                .then()
                .statusCode(200);

        Response res = given()
                .when()
                .get(BASE_PATH + "/" + USERNAME)
                .then()
                .statusCode(200)
                .extract().response();

        String firstName = res.path("firstName");
        assertThat(firstName, is("MuniUpdated"));
       
    }
}

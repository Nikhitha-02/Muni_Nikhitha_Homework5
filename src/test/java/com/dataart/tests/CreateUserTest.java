package com.dataart.tests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class CreateUserTest extends BaseTest {

    @Test
    public void createUser() {
        String payload = "{\n" +
                "  \"id\": 12345,\n" +
                "  \"username\": \"" + USERNAME + "\",\n" +
                "  \"firstName\": \"Muni\",\n" +
                "  \"lastName\": \"Nikhitha\",\n" +
                "  \"email\": \"muni.nikhitha@example.com\",\n" +
                "  \"password\": \"password123\",\n" +
                "  \"phone\": \"9999999999\",\n" +
                "  \"userStatus\": 1\n" +
                "}";

        Response res = given()
                .contentType(ContentType.JSON)
                .body(payload)
                .when()
                .post(BASE_PATH)
                .then()
                .statusCode(anyOf(is(200), is(201)))
                .extract().response();

        int code = res.path("code");
        assertThat(code, anyOf(is(200), is(201)));
    }
}

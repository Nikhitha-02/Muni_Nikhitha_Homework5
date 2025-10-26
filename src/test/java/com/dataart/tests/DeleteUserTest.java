package com.dataart.tests;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class DeleteUserTest extends BaseTest {

    @Test
    public void deleteUser() {
        given()
                .when()
                .delete(BASE_PATH + "/" + USERNAME)
                .then()
                .statusCode(200);

        given()
                .when()
                .get(BASE_PATH + "/" + USERNAME)
                .then()
                .statusCode(anyOf(is(404), is(400)));
    }
}

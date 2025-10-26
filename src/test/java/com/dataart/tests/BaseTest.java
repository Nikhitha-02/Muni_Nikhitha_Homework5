package com.dataart.tests;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;

public class BaseTest {
    protected static final String BASE_URI = "https://petstore.swagger.io/v2";
    protected static final String BASE_PATH = "/user";
    protected static final String USERNAME = "muni_user_" + System.currentTimeMillis();

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = BASE_URI;
        RestAssured.useRelaxedHTTPSValidation();
    }
}

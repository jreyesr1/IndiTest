package com.inditex.test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static org.hamcrest.Matchers.equalTo;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ActiveProfiles("java-test")
class TestApplicationTests {

    String baseURL = "http://localhost:8181/api/v1";

    @BeforeAll
    void setUp() {
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
        RestAssured.baseURI = baseURL;
    }

    @Test
    @DisplayName("Testing Case 1")
    void case1Test() {

        RequestSpecification request = RestAssured.given();

        Response response = request.queryParam("date", "2020-06-14-10.00.00")
                .queryParam("product", 35455)
                .queryParam("brand", 1)
                .get("/prices");

        JsonPath expectedJson = new JsonPath("""
            {
                "priceList": 1,
                "brandId": 1,
                "startDate": "2020-06-14 00:00:00",
                "endDate": "2020-12-31 23:59:59",
                "productId": 35455,                
                "price": 35.5,
                "currency": "EUR"
            }
                                             """);
        response.then().assertThat().body("", equalTo(expectedJson.getMap("")));
    }

    @Test
    @DisplayName("Testing Case 2")
    void case2Test() {

        RequestSpecification request = RestAssured.given();

        Response response = request.queryParam("date", "2020-06-14-16.00.00")
                .queryParam("product", 35455)
                .queryParam("brand", 1)
                .get("/prices");

        JsonPath expectedJson = new JsonPath("""
           {
                "priceList": 2,
                "brandId": 1,
                "startDate": "2020-06-14 15:00:00",
                "endDate": "2020-06-14 18:30:00",
                "productId": 35455,                
                "price": 25.45,
                "currency": "EUR"
            }
                                             """);
        response.then().assertThat().body("", equalTo(expectedJson.getMap("")));
    }

    @Test
    @DisplayName("Testing Case 3")
    void case3Test() {

        RequestSpecification request = RestAssured.given();

        Response response = request.queryParam("date", "2020-06-14-21.00.00")
                .queryParam("product", 35455)
                .queryParam("brand", 1)
                .get("/prices");

        JsonPath expectedJson = new JsonPath("""
           {
               "priceList": 1,
               "brandId": 1,
               "startDate": "2020-06-14 00:00:00",
               "endDate": "2020-12-31 23:59:59",
               "productId": 35455,               
               "price": 35.5,
               "currency": "EUR"
           }
                                             """);
        response.then().assertThat().body("", equalTo(expectedJson.getMap("")));
    }

    @Test
    @DisplayName("Testing Case 4")
    void case4Test() {

        RequestSpecification request = RestAssured.given();

        Response response = request.queryParam("date", "2020-06-15-10.00.00")
                .queryParam("product", 35455)
                .queryParam("brand", 1)
                .get("/prices");

        JsonPath expectedJson = new JsonPath("""
           {
               "priceList": 3,
               "brandId": 1,
               "startDate": "2020-06-15 00:00:00",
               "endDate": "2020-06-15 11:00:00",
               "productId": 35455,               
               "price": 30.5,
               "currency": "EUR"
           }
                                             """);
        response.then().assertThat().body("", equalTo(expectedJson.getMap("")));
    }

    @Test
    @DisplayName("Testing Case 5")
    void case5Test() {

        RequestSpecification request = RestAssured.given();

        Response response = request.queryParam("date", "2020-06-16-21.00.00")
                .queryParam("product", 35455)
                .queryParam("brand", 1)
                .get("/prices");

        JsonPath expectedJson = new JsonPath("""
           {
               "priceList": 4,
               "brandId": 1,
               "startDate": "2020-06-15 16:00:00",
               "endDate": "2020-12-31 23:59:59",
               "productId": 35455,               
               "price": 38.95,
               "currency": "EUR"
           }
                                             """);
        response.then().assertThat().body("", equalTo(expectedJson.getMap("")));
    }

    @Test
    @DisplayName("Testing a badRequest")
    void badRequestTest() {

        RequestSpecification request = RestAssured.given();

        Response response = request.queryParam("date", "foo-bar")
                .queryParam("product", 35455)
                .queryParam("brand", 1)
                .get("/prices");

     
        response.then().assertThat().statusCode(400);
    }

    
    @Test
    @DisplayName("Testing a not found...")
    void priceNotFoundTest() {

        RequestSpecification request = RestAssured.given();

        Response response = request.queryParam("date", "2026-06-16-21.00.00")
                .queryParam("product", 9999)
                .queryParam("brand", 1)
                .get("/prices");

     
        response.then().assertThat().statusCode(404);
    }
}

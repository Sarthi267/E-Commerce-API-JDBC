package com.example.ecommerceapi;

import com.example.ecommerceapi.Product.Product;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import static io.restassured.RestAssured.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThan;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RestAssuredTest {

    @LocalServerPort
    private int port;
    @BeforeEach
    public void setUp() {
        RestAssured.port = port;

    }

    @Test
    public void shouldGetAllProducts() {
        when()
                .get("/products")
                .then()
                .statusCode(200)
                .time(lessThan(2000L));

    }
    @Test
    void shouldCreateNewItem() {
        Product newProduct = new Product("Keyboard", "Black, ergonomic, mechanical", null,"Technology");

        Product createdProduct = given()
                .contentType(ContentType.JSON)
                .body(newProduct)
                .when()
                .post("/products")
                .then()
                .statusCode(200)
                .extract()
                .as(Product.class);

        assertThat(createdProduct.getName()).isEqualTo("Keyboard");
    }
    @Test
    void shouldValidateJsonResponse() {
        given()
                .when()
                .get("/products/1")
                .then()
                .statusCode(200)
                .body("name", equalTo("Keyboard"))
                .body("description", equalTo("Black, ergonomic, mechanical"))
                .body("image", equalTo(null))
                .body("category", equalTo("Technology"));
    }
    @Test
    void shouldReturn400WhenInvalidJsonPost() {
        String badJson = """
                {"name":null,
                "description": "",
                "image":"",
                "category": ""
                }
                """;
        given()
                .contentType(ContentType.JSON)
                .body(badJson)
                .when()
                .post("/products")

                .then()
                .statusCode(400);
    }
}


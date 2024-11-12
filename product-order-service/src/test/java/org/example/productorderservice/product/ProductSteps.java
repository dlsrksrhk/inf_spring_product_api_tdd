package org.example.productorderservice.product;

import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.springframework.http.MediaType;

public class ProductSteps {
    public static AddProductRequest 상품등록_요청_생성() {
        final int price = 1000;
        final String name = "상품명";
        final DiscountPolicy discountPolicy = DiscountPolicy.NONE;
        final AddProductRequest request = new AddProductRequest(name, price, discountPolicy);
        return request;
    }

    public static ExtractableResponse<Response> 상품등록_요청(AddProductRequest request) {
        ExtractableResponse<Response> response = RestAssured.given().log().all()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(request)
                .when()
                .post("/products")
                .then()
                .log().all().extract();

        return response;
    }


    public static ExtractableResponse<Response> 상품_조회_요청(long productId) {
        var response = RestAssured.given().log().all()
                .when()
                .get("/products/{productId}", productId)
                .then()
                .log().all().extract();
        return response;
    }
}

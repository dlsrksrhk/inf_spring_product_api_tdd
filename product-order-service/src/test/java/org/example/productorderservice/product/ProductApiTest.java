package org.example.productorderservice.product;

import org.example.productorderservice.ApiTest;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import static org.assertj.core.api.Assertions.assertThat;

public class ProductApiTest extends ApiTest {

    @Test
    void 상품조회() {
        final var request = ProductSteps.상품등록_요청_생성();
        ProductSteps.상품등록_요청(request);

        var productId = 1L;
        var response = ProductSteps.상품_조회_요청(productId);

        assertThat(response.statusCode()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.jsonPath().getString("name")).isEqualTo("상품명");
        assertThat(response.jsonPath().getInt("price")).isEqualTo(1000);
        assertThat(response.jsonPath().getString("discountPolicy")).isEqualTo("NONE");
    }

    @Test
    void 상품등록() {
        final var request = ProductSteps.상품등록_요청_생성();
        final var response = ProductSteps.상품등록_요청(request);

        assertThat(response.statusCode()).isEqualTo(HttpStatus.CREATED.value());
    }

}

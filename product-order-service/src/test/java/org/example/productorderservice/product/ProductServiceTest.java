package org.example.productorderservice.product;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class ProductServiceTest {
    @Autowired
    private ProductService productService;

    @Test
    void 상품조회() {
        상품등록();
        final long productId = 1L;
        final var response = productService.getProduct(productId);

        assertThat(response).isNotNull();
    }

    @Test
    void 상품등록() {
        final AddProductRequest request = ProductSteps.상품등록_요청_생성();
        productService.addProduct(request);
    }

}

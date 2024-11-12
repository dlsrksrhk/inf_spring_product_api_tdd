package org.example.productorderservice.product;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProductServiceTest {
    private ProductService productService;

    @BeforeEach
    void setUp() {
        final ProductPort productPort = new ProductPort() {
            @Override
            public void save(Product product) {

            }

            @Override
            public Product getProduct(long productId) {
                return new Product("상품명", 1000, DiscountPolicy.NONE);
            }
        };

        productService = new ProductService(productPort);
    }


    @Test
    void 상품수정() {
        final Long productId = 1L;
        final UpdateProductRequest request = new UpdateProductRequest("상품수정", 2000, DiscountPolicy.NONE);
        productService.updateProduct(productId, request);
//        assertThat(response.statusCode()).isEqualTo(HttpStatus.OK.value());
    }
}

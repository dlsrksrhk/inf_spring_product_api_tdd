package org.example.productorderservice.product;

import org.springframework.util.Assert;

class Product {
    private Long id;
    private final String name;
    private final int price;
    private final DiscountPolicy discountPolicy;

    public Product(String name, int price, DiscountPolicy discountPolicy) {
        Assert.hasText(name, "상품명은 필수입니다.");
        Assert.isTrue(price > 0, "사품 가격은 0 보다 커야합니다.");
        Assert.notNull(discountPolicy, "할인 정책은 필수입니다.");

        this.name = name;
        this.price = price;
        this.discountPolicy = discountPolicy;
    }

    public void assisgnId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}

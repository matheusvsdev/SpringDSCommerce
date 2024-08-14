package com.matheusdev.dscommerce.dto;

import com.matheusdev.dscommerce.entities.OrderItem;

public class OrderItemDTO {

    private Long productId;

    private String name;

    private Double price;

    private Integer quantity;

    public OrderItemDTO(Long productId, String name, Double price, Integer quantity) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public OrderItemDTO(OrderItem orderItem) {
        productId = orderItem.getOrder().getId();
        name = orderItem.getProduct().getName();
        price = orderItem.getPrice();
        quantity = orderItem.getQuantity();
    }

    public Long getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Double getSubTotal() {
        return price * quantity;
    }
}

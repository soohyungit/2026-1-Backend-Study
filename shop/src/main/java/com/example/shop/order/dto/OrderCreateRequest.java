package com.example.shop.order.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class OrderCreateRequest {
    private Long memberId;
    private int totalPrice;
    private int pointUsed;
    private int cashAmount;
    private String status;
}
package com.amperezp14.JavaTest.prices.infraestructure.rest;

import lombok.*;

import java.time.LocalDateTime;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PriceResponse {
    int product_id,brand_id,price_list;
    double price;
    LocalDateTime start_date, end_date;
}

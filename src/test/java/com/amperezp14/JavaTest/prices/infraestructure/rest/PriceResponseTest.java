package com.amperezp14.JavaTest.prices.infraestructure.rest;

import com.amperezp14.JavaTest.prices.domain.Price;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDateTime;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(MockitoJUnitRunner.class)
class PriceResponseTest {
    private PriceResponse priceResponse;

    @Test
    void PriceResponse() {
        priceResponse = new PriceResponse();
        assertNotNull(priceResponse);
    }

    @Test
    void builder() {
        LocalDateTime localDateTimeStart = LocalDateTime.of(2020,
                Month.JULY, 14, 19, 30, 40);
        LocalDateTime localDateTimeEnd = LocalDateTime.of(2020,
                Month.AUGUST, 14, 19, 30, 40);

        PriceResponse priceResponse = PriceResponse.builder().
                product_id(1).
                brand_id(1).
                price_list(1).
                price(20.45).
                start_date(localDateTimeStart).
                end_date(localDateTimeEnd).
                build();

        assertEquals(1, priceResponse.getProduct_id());
        assertEquals(1, priceResponse.getBrand_id());
        assertEquals(1, priceResponse.getPrice_list());
        assertEquals(20.45, priceResponse.getPrice());
        assertEquals(localDateTimeStart, priceResponse.getStart_date());
        assertEquals(localDateTimeEnd, priceResponse.getEnd_date());

    }
}
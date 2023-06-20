package com.amperezp14.JavaTest.prices.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDateTime;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(MockitoJUnitRunner.class)
class PriceTest {

    private Price price;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void Price() {
        price = new Price();
        assertNotNull(price);
    }



    @Test
    void builder() {
        LocalDateTime localDateTimeStart = LocalDateTime.of(2020,
                Month.JULY, 14, 19, 30, 40);
        LocalDateTime localDateTimeEnd = LocalDateTime.of(2020,
                Month.AUGUST, 14, 19, 30, 40);
        Price price = Price.builder().
                id(1).
                product_id(1).
                brand_id(1).
                price_list(1).
                price(20.45).
                priority(1).
                curr("EUR").
                start_date(localDateTimeStart).
                end_date(localDateTimeEnd).build();
        assertEquals(1, price.getId());
        assertEquals(1, price.getProduct_id());
        assertEquals(1, price.getBrand_id());
        assertEquals(1, price.getPrice_list());
        assertEquals(20.45, price.getPrice());
        assertEquals(1, price.getPriority());
        assertEquals("EUR", price.getCurr());
        assertEquals(localDateTimeStart, price.getStart_date());
        assertEquals(localDateTimeEnd, price.getEnd_date());
    }
}
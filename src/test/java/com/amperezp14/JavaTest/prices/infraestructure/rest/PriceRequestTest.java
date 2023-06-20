package com.amperezp14.JavaTest.prices.infraestructure.rest;

import com.amperezp14.JavaTest.prices.domain.Price;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDateTime;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(MockitoJUnitRunner.class)
class PriceRequestTest {

    private PriceRequest priceRequest;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void PriceRequest() {
        priceRequest = new PriceRequest();
        assertNotNull(priceRequest);
    }

    @Test
    void builder() {
        LocalDateTime localDateTimeApplication = LocalDateTime.of(2020,
                Month.JULY, 21, 19, 30, 40);
        PriceRequest priceRequest = PriceRequest.builder().
                product_id(1).
                brand_id(1).
                application_date(localDateTimeApplication).build();
        assertEquals(1, priceRequest.getProduct_id());
        assertEquals(1, priceRequest.getBrand_id());
        assertEquals(localDateTimeApplication, priceRequest.getApplication_date());
    }
}
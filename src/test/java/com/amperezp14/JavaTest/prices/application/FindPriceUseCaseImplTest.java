package com.amperezp14.JavaTest.prices.application;

import com.amperezp14.JavaTest.prices.domain.Price;
import com.amperezp14.JavaTest.prices.infraestructure.repository.IPriceRepository;
import com.amperezp14.JavaTest.prices.infraestructure.rest.PriceRequest;
import com.amperezp14.JavaTest.prices.infraestructure.rest.PriceResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.chrono.ChronoLocalDateTime;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
class FindPriceUseCaseImplTest {

    @Mock
    private IPriceRepository priceRepository;
    @InjectMocks
    private FindPriceUseCaseImpl findPriceUseCase;

    private Price price;
    private LocalDateTime localDateTimeStart, localDateTimeEnd, localDateTimeApplication;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        this.localDateTimeStart = LocalDateTime.of(2023,
                Month.JULY, 14, 19, 30, 40);
        this.localDateTimeEnd = LocalDateTime.of(2023,
                Month.AUGUST, 15, 19, 30, 40);
        this.localDateTimeApplication = LocalDateTime.of(2023,
                Month.JULY, 21, 19, 30, 40);
            price = Price.builder().
                id(1).
                product_id(1).
                brand_id(1).
                price_list(1).
                price(20.45).
                priority(1).
                curr("EUR").
                start_date(localDateTimeStart).
                end_date(localDateTimeEnd).build();
    }

    @Test
    void findPrice() {
        Mockito.when(priceRepository.findAll()).thenReturn(Arrays.asList(this.price));
        List<Price> priceList = priceRepository.findAll();
        assertNotNull(priceList);
        assertEquals(1,priceList.get(0).getId());
        assertEquals(1,priceList.get(0).getProduct_id());
        assertEquals(1,priceList.get(0).getBrand_id());
        assertEquals(20.45,priceList.get(0).getPrice(),0.001);
        assertEquals(1,priceList.get(0).getPriority());
        assertEquals("EUR",priceList.get(0).getCurr());
        assertEquals(LocalDateTime.of(2023,
                Month.JULY, 14, 19, 30, 40),priceList.get(0).getStart_date());
        assertEquals(LocalDateTime.of(2023,
                Month.AUGUST, 15, 19, 30, 40),priceList.get(0).getEnd_date());
    }
}
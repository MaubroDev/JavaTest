package com.amperezp14.JavaTest.prices.infraestructure.controller;

import com.amperezp14.JavaTest.prices.application.IFindPriceUseCase;
import com.amperezp14.JavaTest.prices.domain.Price;
import com.amperezp14.JavaTest.prices.infraestructure.rest.PriceRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.io.UnsupportedEncodingException;
import java.time.LocalDateTime;
import java.time.Month;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@AutoConfigureMockMvc
@SpringBootTest
class PriceControllerTest {

    private static ObjectMapper mapper = new ObjectMapper();

    @BeforeEach
    void setUp() {
        mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
    }

    @Autowired
    private MockMvc mvc;

    @Autowired
    private IFindPriceUseCase iFindPriceUseCase;

    private  Price price;


    @Test
    void getPrice_When_TheTimeIs141000() {
        PriceRequest priceRequest141000 = new PriceRequest(35455, 1, LocalDateTime.of(2023, Month.JULY, 14, 10, 0, 0));
        try {

            String json = mapper.writeValueAsString(priceRequest141000);
            mvc.perform(get("/prices/getPrice").contentType(MediaType.APPLICATION_JSON).characterEncoding("utf-8")
                            .content(json).accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
                    .andExpect(jsonPath("$.product_id", Matchers.equalTo(35455)))
                    .andExpect(jsonPath("$.brand_id", Matchers.equalTo(1)))
                    .andExpect(jsonPath("$.price_list", Matchers.equalTo(1)))
                    .andExpect(jsonPath("$.price", Matchers.equalTo(35.5)))
                    .andExpect(jsonPath("$.start_date", Matchers.equalTo("2023-06-14T00:00:00")))
                    .andExpect(jsonPath("$.end_date", Matchers.equalTo("2023-12-31T23:59:59")));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void getPrice_When_TheTimeIs141600() {
        PriceRequest priceRequest141600 = new PriceRequest(35455, 1, LocalDateTime.of(2023, Month.JULY, 14, 16, 0, 0));
        try {

            String json = mapper.writeValueAsString(priceRequest141600);
            mvc.perform(get("/prices/getPrice").contentType(MediaType.APPLICATION_JSON).characterEncoding("utf-8")
                            .content(json).accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
                    .andExpect(jsonPath("$.product_id", Matchers.equalTo(35455)))
                    .andExpect(jsonPath("$.brand_id", Matchers.equalTo(1)))
                    .andExpect(jsonPath("$.price_list", Matchers.equalTo(1)))
                    .andExpect(jsonPath("$.price", Matchers.equalTo(35.5)))
                    .andExpect(jsonPath("$.start_date", Matchers.equalTo("2023-06-14T00:00:00")))
                    .andExpect(jsonPath("$.end_date", Matchers.equalTo("2023-12-31T23:59:59")));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void getPrice_When_TheTimeIs142100() {
        PriceRequest priceRequest1421000 = new PriceRequest(35455, 1, LocalDateTime.of(2023, Month.JULY, 14, 21, 0, 0));
        try {

            String json = mapper.writeValueAsString(priceRequest1421000);
            mvc.perform(get("/prices/getPrice").contentType(MediaType.APPLICATION_JSON).characterEncoding("utf-8")
                            .content(json).accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
                    .andExpect(jsonPath("$.product_id", Matchers.equalTo(35455)))
                    .andExpect(jsonPath("$.brand_id", Matchers.equalTo(1)))
                    .andExpect(jsonPath("$.price_list", Matchers.equalTo(1)))
                    .andExpect(jsonPath("$.price", Matchers.equalTo(35.5)))
                    .andExpect(jsonPath("$.start_date", Matchers.equalTo("2023-06-14T00:00:00")))
                    .andExpect(jsonPath("$.end_date", Matchers.equalTo("2023-12-31T23:59:59")));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void getPrice_When_TheTimeIs151000() {
        PriceRequest priceRequest151000 = new PriceRequest(35455, 1, LocalDateTime.of(2023, Month.JULY, 15, 10, 0, 0));
        try {

            String json = mapper.writeValueAsString(priceRequest151000);
            mvc.perform(get("/prices/getPrice").contentType(MediaType.APPLICATION_JSON).characterEncoding("utf-8")
                            .content(json).accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
                    .andExpect(jsonPath("$.product_id", Matchers.equalTo(35455)))
                    .andExpect(jsonPath("$.brand_id", Matchers.equalTo(1)))
                    .andExpect(jsonPath("$.price_list", Matchers.equalTo(1)))
                    .andExpect(jsonPath("$.price", Matchers.equalTo(35.5)))
                    .andExpect(jsonPath("$.start_date", Matchers.equalTo("2023-06-14T00:00:00")))
                    .andExpect(jsonPath("$.end_date", Matchers.equalTo("2023-12-31T23:59:59")));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void getPrice_When_TheTimeIs162100() {
        PriceRequest priceRequest162100 = new PriceRequest(35455, 1, LocalDateTime.of(2023, Month.JULY, 16, 21, 0, 0));
        try {

            String json = mapper.writeValueAsString(priceRequest162100);
            mvc.perform(get("/prices/getPrice").contentType(MediaType.APPLICATION_JSON).characterEncoding("utf-8")
                            .content(json).accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
                    .andExpect(jsonPath("$.product_id", Matchers.equalTo(35455)))
                    .andExpect(jsonPath("$.brand_id", Matchers.equalTo(1)))
                    .andExpect(jsonPath("$.price_list", Matchers.equalTo(1)))
                    .andExpect(jsonPath("$.price", Matchers.equalTo(35.5)))
                    .andExpect(jsonPath("$.start_date", Matchers.equalTo("2023-06-14T00:00:00")))
                    .andExpect(jsonPath("$.end_date", Matchers.equalTo("2023-12-31T23:59:59")));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
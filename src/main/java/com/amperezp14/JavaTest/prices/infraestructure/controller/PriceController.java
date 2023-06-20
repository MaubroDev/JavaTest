package com.amperezp14.JavaTest.prices.infraestructure.controller;

import com.amperezp14.JavaTest.prices.application.IFindPriceUseCase;
import com.amperezp14.JavaTest.prices.infraestructure.rest.PriceRequest;
import com.amperezp14.JavaTest.prices.infraestructure.rest.PriceResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("prices")
public class PriceController {

    @Autowired
    private IFindPriceUseCase findPriceUseCase;

    @GetMapping("/getPrice")
    public ResponseEntity<PriceResponse> getPrice(@RequestBody @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) PriceRequest data) {
        PriceResponse priceResponse = findPriceUseCase.findPrice(data);
        if (priceResponse!=null)
            return new ResponseEntity<>(priceResponse, HttpStatus.OK);
        else
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

}

package com.amperezp14.JavaTest.prices.application;

import com.amperezp14.JavaTest.prices.infraestructure.rest.PriceRequest;
import com.amperezp14.JavaTest.prices.infraestructure.rest.PriceResponse;

public interface IFindPriceUseCase {

    public PriceResponse findPrice(PriceRequest priceRequest);

}

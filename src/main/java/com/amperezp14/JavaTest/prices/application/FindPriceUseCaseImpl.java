package com.amperezp14.JavaTest.prices.application;

import com.amperezp14.JavaTest.prices.domain.Price;
import com.amperezp14.JavaTest.prices.infraestructure.repository.IPriceRepository;
import com.amperezp14.JavaTest.prices.infraestructure.rest.PriceRequest;
import com.amperezp14.JavaTest.prices.infraestructure.rest.PriceResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class FindPriceUseCaseImpl implements IFindPriceUseCase {

    @Autowired
    private IPriceRepository priceRepository;

    @Override
    public PriceResponse findPrice(PriceRequest priceRequest) {
            List<Price> priceList =  priceRepository.findAll().stream().filter(price -> price.getProduct_id() == priceRequest.getProduct_id()).collect(Collectors.toList());
            List<Price> prices = priceList.stream().filter(price -> filterDatesByRange(price, priceRequest)).sorted(Comparator.comparingInt(Price::getPriority)).limit(1).collect(Collectors.toList());
            if (prices!=null && !prices.isEmpty()){
                return PriceResponse.builder().
                        product_id(prices.get(0).getProduct_id()).
                        brand_id(prices.get(0).getBrand_id()).
                        price_list(prices.get(0).getPrice_list()).
                        price(prices.get(0).getPrice()).
                        start_date(prices.get(0).getStart_date()).
                        end_date(prices.get(0).getEnd_date()).
                        build();
            }
            else
                return null;
    }
    private boolean filterDatesByRange(Price price, PriceRequest priceRequest){
        return (price.getStart_date().isBefore(priceRequest.getApplication_date()) && price.getEnd_date().isAfter(priceRequest.getApplication_date()));
    }
}

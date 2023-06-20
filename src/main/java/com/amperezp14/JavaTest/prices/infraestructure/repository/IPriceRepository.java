package com.amperezp14.JavaTest.prices.infraestructure.repository;

import com.amperezp14.JavaTest.prices.domain.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IPriceRepository extends JpaRepository<Price, Integer> {
}
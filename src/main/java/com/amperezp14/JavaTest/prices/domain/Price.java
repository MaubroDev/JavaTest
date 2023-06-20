package com.amperezp14.JavaTest.prices.domain;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;


@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "prices")
public class Price implements Serializable {
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    private int brand_id;
    private int price_list;
    private int product_id;
    private int priority;
    private double price;
    private String curr;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", shape = JsonFormat.Shape.STRING)
    private LocalDateTime start_date;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", shape = JsonFormat.Shape.STRING)
    private LocalDateTime end_date;
}
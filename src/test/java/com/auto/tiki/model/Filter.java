package com.auto.tiki.model;

import com.auto.tiki.enums.Brands;
import com.auto.tiki.enums.Colors;
import com.auto.tiki.enums.Offers;
import com.auto.tiki.enums.Suppliers;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class Filter {
    private String service;
    private Offers offers;
    private String rating;
    private int minimumPrice;
    private int maximumPrice;
    private Set<Brands> brands;
    private Set<Colors> colors;
    private Set<Suppliers> suppliers;
    private String deliveryType;

}

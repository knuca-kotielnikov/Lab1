package com.knuba.lab3;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class Hotel {

    private String name;

    private String city;

    private String category;

    private int totalPlaceAmount;

    private int freePlaceAmount;
}

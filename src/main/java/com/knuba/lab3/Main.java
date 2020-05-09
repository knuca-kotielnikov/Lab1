package com.knuba.lab3;

import com.knuba.lab3.comparators.CityComparator;
import com.knuba.lab3.comparators.FreePlaceComparator;
import com.knuba.lab3.comparators.NameComparator;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Hotel hotel1 = buildHotelInstance("The Spectator Hotel", "Kiev", "C1", 53, 21);
        Hotel hotel2 = buildHotelInstance("The Lowell", "New York", "B3", 103, 63);
        Hotel hotel3 = buildHotelInstance("Vidanta Nuevo Vallarta", "Seul", "A2", 47, 4);
        Hotel hotel4 = buildHotelInstance("The Temple House", "London", "B1", 22, 14);

        List<Hotel> hotels = new ArrayList<Hotel>();

        hotels.add(hotel1);
        hotels.add(hotel2);
        hotels.add(hotel3);
        hotels.add(hotel4);
        hotels.forEach(System.out::println);
        System.out.println();

        System.out.println("-------------Sort by city----------------");
        sort(hotels, new CityComparator());

        System.out.println("--------------Sort by free places---------------");
        sort(hotels, new FreePlaceComparator());

        System.out.println("------------Sort by name-----------------");
        sort(hotels, new NameComparator());

        System.out.println("------------Sort by totalPlaceAmount-----------------");
        sort(hotels, Comparator.comparingInt(Hotel::getTotalPlaceAmount));
    }

    public static void sort(List<Hotel> hotels, Comparator<Hotel> comparator) {
        hotels.sort(comparator);
        hotels.forEach(System.out::println);
        System.out.println();
    }

    private static Hotel buildHotelInstance(String name,
                                      String city,
                                      String category,
                                      int totalPlaceAmount,
                                      int freePlaceAmount) {
        return Hotel.builder()
                .name(name)
                .city(city)
                .category(category)
                .totalPlaceAmount(totalPlaceAmount)
                .freePlaceAmount(freePlaceAmount)
                .build();
    }
}

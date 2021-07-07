package com.example.demo;

import java.util.Arrays;
import java.util.HashMap;

public class CarPooling {
    private boolean result = true;
    public boolean compute(int[][] trips, int capacity) {
        HashMap<Integer, Integer> loads = new HashMap<>();

        Arrays.stream(trips).forEach(trip -> {
            int passengerNumbers = trip[0];
            int startLocation = trip[1];
            int endLocation = trip[2];

            for (int i = startLocation; i < endLocation; i++) {
                if(loads.putIfAbsent(i, passengerNumbers) != null) {
                    loads.computeIfPresent(i, (k, v) -> v + passengerNumbers);
                }

                if(loads.get(i) > capacity) {
                    result = false;
                    break;
                };
            }
        });

        return result;
    }

}

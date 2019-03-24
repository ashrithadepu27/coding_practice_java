package com.coding.challenge.amazon;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class TruckDistribution {


    public class Parcel {
        List<Integer> coordinates;
        Double dist;

        Parcel(List<Integer> coordinates) {
            this.coordinates = coordinates;
            this.dist =  Math.pow(coordinates.get(0), 2) + Math.pow(coordinates.get(1), 2);
        }

        public List<Integer> getCoordinates() {
            return this.coordinates;
        }

        public Double getDistance() {
            return this.dist;
        }
    }

    public List<List<Integer>> closestLocations(int totalCrates, List<List<Integer>> allLocations, int truckCapacity) {

        if(totalCrates <= truckCapacity) return allLocations;
        if(totalCrates <= 0 || truckCapacity <= 0) return new LinkedList<>();;
        PriorityQueue<Parcel> truckParcel = new PriorityQueue<>(new Comparator<Parcel>() {
            @Override
            public int compare(Parcel p1, Parcel p2) {
                return p1.getDistance().compareTo(p2.getDistance());
            }
        });

        for(List<Integer> parcelLocation : allLocations) {
            truckParcel.add(new Parcel(parcelLocation));
        }

        List<List<Integer>> result = new LinkedList<>();
        while(truckCapacity > 0 && !truckParcel.isEmpty()) {
            result.add(truckParcel.poll().getCoordinates());
            truckCapacity--;
        }

        return result;
    }


    public static void main(String[] args) {

        TruckDistribution t = new TruckDistribution();

        int totalCrates = 6, truckCapacity = 3;
        List<List<Integer>> allLocations = new LinkedList<>();
        List<Integer> coordinates = new LinkedList<>();
        coordinates.add(3);
        coordinates.add(6);
        allLocations.add(new LinkedList<>(coordinates));

        coordinates.clear();
        coordinates.add(2);
        coordinates.add(4);
        allLocations.add(new LinkedList<>(coordinates));

        coordinates.clear();
        coordinates.add(5);
        coordinates.add(3);
        allLocations.add(new LinkedList<>(coordinates));

        coordinates.clear();
        coordinates.add(2);
        coordinates.add(7);
        allLocations.add(new LinkedList<>(coordinates));

        coordinates.clear();
        coordinates.add(1);
        coordinates.add(8);
        allLocations.add(new LinkedList<>(coordinates));

        coordinates.clear();
        coordinates.add(7);
        coordinates.add(9);
        allLocations.add(new LinkedList<>(coordinates));

        List<List<Integer>> result = t.closestLocations(totalCrates, allLocations, truckCapacity);

        for(List<Integer> p : result) {
            System.out.println(p);
        }
    }
}

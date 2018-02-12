package oop.parkingLot;

import oop.parkingLot.vehicle.Vehicle;

import java.util.*;

public class MyParkingLot implements ParkingLot {
    private int id;
    private Deque<Lot> unused;
    private Map<Integer, Lot> used;

    public MyParkingLot(int id, int n) {
        this.id = id;
        this.unused = new ArrayDeque<>();
        this.used = new HashMap<>();
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            this.unused.push(new Lot(i, random.nextInt(2) + 1));
        }
    }

    @Override
    public int pushVehicle(Vehicle vehicle) {
        if (unused.isEmpty()) { return -1; }
        Lot lot = unused.pop();
        lot.setVehicle(vehicle);
        used.put(vehicle.id, lot);
        return lot.getId();
    }

    @Override
    public int popVehicle(Vehicle vehicle) {
        if (!used.containsKey(vehicle.id)) { return -1; }
        Lot lot = used.get(vehicle.id);
        used.remove(lot);
        lot.setVehicle(null);
        unused.push(lot);
        return lot.getId();
    }
}

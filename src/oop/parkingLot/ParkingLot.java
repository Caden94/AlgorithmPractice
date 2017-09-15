package oop.parkingLot;

import oop.parkingLot.vehicle.Vehicle;

public interface ParkingLot {
    int pushVehicle(Vehicle vehicle);
    int popVehicle(Vehicle vehicle);
}

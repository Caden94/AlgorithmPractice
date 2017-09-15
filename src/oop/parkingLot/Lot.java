package oop.parkingLot;

import oop.parkingLot.vehicle.Vehicle;

public class Lot {
    private int id;
    private int size;
    private Vehicle vehicle;
    private boolean hasVehicle;

    public Lot(int id, int size) {
        this.id = id;
        this.size = size;
        this.hasVehicle = false;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public boolean setVehicle(Vehicle vehicle) {
        if (vehicle == null) {
            this.hasVehicle = false;
        } else {
            if (vehicle.size > this.size) { return false; }
            this.hasVehicle = true;
            this.vehicle = vehicle;
        }
        return true;
    }

    public boolean isHasVehicle() {
        return hasVehicle;
    }

    public void setHasVehicle(boolean hasVehicle) {
        this.hasVehicle = hasVehicle;
    }

}

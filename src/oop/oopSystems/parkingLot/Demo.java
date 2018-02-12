package oop.parkingLot;

import oop.parkingLot.vehicle.Car;
import oop.parkingLot.vehicle.Truck;
import oop.parkingLot.vehicle.Vehicle;

public class Demo {
    public static void main(String[] args) {
        MyParkingLot myParkingLot = new MyParkingLot(0, 2);
        // generate vehicles
        Vehicle vehicle0 = new Car(0);
        Vehicle vehicle1 = new Truck(1);
        Vehicle vehicle2 = new Car(2);

        System.out.println(myParkingLot.pushVehicle(vehicle0));
        System.out.println(myParkingLot.pushVehicle(vehicle1));
        System.out.println(myParkingLot.pushVehicle(vehicle2));


        System.out.println(myParkingLot.popVehicle(vehicle0));
        System.out.println(myParkingLot.popVehicle(vehicle1));
        System.out.println(myParkingLot.popVehicle(vehicle2));
    }
}

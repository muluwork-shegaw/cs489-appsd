package cs489.project.carrental.model;

import cs489.project.carrental.model.helperClass.AvailabilityStatus;
import cs489.project.carrental.model.helperClass.VehicleType;

import java.util.List;

public class Vehicle {
    private  String vehicleID;
    private  String make;
    private  String model;
    private VehicleType vehicleType;
    private List<Car> cars;
    private int seatNum;


}

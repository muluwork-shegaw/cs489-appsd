package cs489.project.carrental.model;

import cs489.project.carrental.model.helperClass.AvailabilityStatus;

import java.time.LocalDateTime;
import java.util.List;

public class Car extends Vehicle{
    private int year;
    private String licensePlate;
    private float rentalRate;
    private AvailabilityStatus availabilityStatus;
    private float startPrice;
    private Address location;
    private Branch branch;
    private List<Review> reviewList;
    private String registrationId;
    private LocalDateTime insuranceExpDate;


}

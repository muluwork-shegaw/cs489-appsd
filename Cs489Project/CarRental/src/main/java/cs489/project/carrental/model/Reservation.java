package cs489.project.carrental.model;

import cs489.project.carrental.model.helperClass.ReservationStatus;

import java.time.LocalDateTime;

public class Reservation {
    private Long reservationID;
    private float price;

    private LocalDateTime dateTimeStart;
    private LocalDateTime dateTimeEnd;
    private Branch pickupLocation;
    private Branch dropOffLocation;
    private Car car;

    private Service service;
    private Agreement agreement;
    private ReservationStatus status;
    private Bill bill;
    private Feedback feedback;


}

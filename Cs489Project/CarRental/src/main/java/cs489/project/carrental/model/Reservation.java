package cs489.project.carrental.model;

import cs489.project.carrental.model.helperClass.ReservationStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reservationID;
    private float price;

    private LocalDateTime dateTimeStart;
    private LocalDateTime dateTimeEnd;
    @ManyToOne
    private Branch pickupLocation;
    @ManyToOne
    private Branch dropOffLocation;
    @OneToOne
    private Car car;
    @OneToOne
    private Service service;
    @OneToOne
    private Agreement agreement;
    private ReservationStatus status;
    @OneToOne(mappedBy = "reservation")
    private Bill bill;
    @OneToOne(mappedBy = "reservation")

    private Feedback feedback;


}

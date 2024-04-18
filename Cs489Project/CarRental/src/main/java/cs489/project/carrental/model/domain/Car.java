package cs489.project.carrental.model.domain;

import cs489.project.carrental.model.helperClass.AvailabilityStatus;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
@Data
@Entity
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long carID;
    private int year;
    private String licensePlate;
    private float rentalRate;

    @Enumerated(EnumType.STRING)
    private AvailabilityStatus availabilityStatus;

    private float startPrice;


    private String registrationId;
    private LocalDateTime insuranceExpDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "carTypeOfVehicle_id", insertable = false, updatable = false)
    private Vehicle vehicle;

    @ManyToOne
    @JoinColumn(name = "branch_id")
    private Branch branch;

    @OneToMany(mappedBy = "car")
    private List<Review> reviewList;


}

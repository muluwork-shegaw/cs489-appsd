package cs489.project.carrental.model;

import cs489.project.carrental.model.helperClass.AvailabilityStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Car extends Vehicle{

    private int year;
    private String licensePlate;
    private float rentalRate;
    @Enumerated(EnumType.STRING)

    private AvailabilityStatus availabilityStatus;
    private float startPrice;


    private String registrationId;
    private LocalDateTime insuranceExpDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vehicle_id", insertable = false, updatable = false)
    private Vehicle vehicle;

    @ManyToOne
    @JoinColumn(name = "branch_id") // Reference to the Branch entity
    private Branch branch;

    @OneToMany(mappedBy = "car")
    private List<Review> reviewList;


}

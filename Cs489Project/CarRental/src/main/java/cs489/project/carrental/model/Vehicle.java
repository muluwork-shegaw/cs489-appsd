package cs489.project.carrental.model;

import cs489.project.carrental.model.helperClass.AvailabilityStatus;
import cs489.project.carrental.model.helperClass.VehicleType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.JOINED)

public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long vehicleID;
    private  String make;
    private  String model;

    private VehicleType vehicleType;
    @OneToMany
    private List<Car> cars;
    private int seatNum;


}

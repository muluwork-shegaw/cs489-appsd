package cs489.project.carrental.model;

import cs489.project.carrental.model.helperClass.ServiceType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long serviceID;
    @Enumerated(EnumType.STRING)

    private ServiceType serviceType;
    private String description;
    private float price;
}

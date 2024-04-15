package cs489.project.carrental.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Agreement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String agreementID;
    private String description;
    private String policy;
    @OneToOne
    private Customer customer;

    @OneToOne
    private RentalAgent rentalAgent;
}

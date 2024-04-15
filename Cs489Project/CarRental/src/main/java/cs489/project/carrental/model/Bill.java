package cs489.project.carrental.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long billId;
    private LocalDateTime date;
    private float amount;
    @ManyToOne
    private Customer customer;
    @ManyToOne
    private RentalAgent rentalAgent;
    @OneToOne
    private Reservation reservation;
    private String description;


}

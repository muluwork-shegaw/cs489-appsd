package cs489.project.carrental.model;

import cs489.project.carrental.model.helperClass.Rate;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Feedback {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long feedbackId;
    private LocalDateTime localDateTime;
    private String comment;

    @ManyToOne
    private Customer customer;
    @OneToOne
    private Reservation reservation;


}

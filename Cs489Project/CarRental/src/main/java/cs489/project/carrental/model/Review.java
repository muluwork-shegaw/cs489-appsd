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
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reviewId;

    private LocalDateTime localDateTime;
    @Enumerated(EnumType.STRING)

    private Rate rate;
    @ManyToOne
    private Car car;
    private String comment;



}

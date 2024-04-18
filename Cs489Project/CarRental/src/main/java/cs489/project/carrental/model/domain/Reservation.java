package cs489.project.carrental.model.domain;

import cs489.project.carrental.model.helperClass.ReservationStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

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

    @Enumerated(EnumType.STRING)
    private ReservationStatus reservationStatus;


    @ManyToOne
    private Branch pickupLocation;

    @ManyToOne
    private Branch dropOffLocation;

    @OneToOne
    private Car car;

    @OneToOne
    private Service service;

    @OneToOne(mappedBy = "reservation")
    private Bill bill;

    @OneToOne(mappedBy = "reservation")
    private Feedback feedback;

    @ManyToOne
    private Customer customer;

    @Column(
            name = "created_at",
            nullable = false
    )
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(
            name = "updated_at",
            nullable = false
    )
    @UpdateTimestamp
    private LocalDateTime updatedAt;

}

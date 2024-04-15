package cs489.project.carrental.model;

import java.time.LocalDateTime;

public class Bill {
    private Long billId;
    private LocalDateTime date;
    private float amount;
    private RentalAgent rentalAgent;
    private String description;


}

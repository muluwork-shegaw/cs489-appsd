package cs489.project.carrental.model.domain;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
@Data
@Entity
public class Customer extends User {


    @Temporal(TemporalType.DATE)
    private Date dob;

    private String driverLicenceId;

    @OneToOne
    private Badge badge;

    @OneToMany(mappedBy = "customer")
    private List<Card> cards;

    @OneToMany(mappedBy = "customer")
    private List<Reservation> reservations;

}

package cs489.project.carrental.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EqualsAndHashCode(callSuper = true)

public class Customer extends User{

    private String driverLicenceId;

    @Temporal(TemporalType.DATE)
    private Date dob;

    @OneToOne
    private Badge badge;

    @OneToMany(mappedBy = "customer")
    private List<Card> cards;

    @OneToMany(mappedBy = "customer")
    private List<Reservation> reservations;

    @OneToOne(cascade = CascadeType.ALL)
    private Login login;


}

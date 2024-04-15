package cs489.project.carrental.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Branch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long branchId;
    private String branchName;
    private String branchLicence;
    private String picture;
    @OneToMany(mappedBy = "branch")
    private List<RentalAgent> rentalAgents;

    @OneToOne
    private Address address;

    @OneToMany(mappedBy = "branch")
    private List<Vehicle> vehicles;


}

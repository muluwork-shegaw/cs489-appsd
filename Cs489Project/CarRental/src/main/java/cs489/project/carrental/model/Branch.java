package cs489.project.carrental.model;

import java.util.List;

public class Branch {

    private Long branchId;
    private String branchName;
    private String branchLicence;

    private List<RentalAgent> rentalAgents;
    private Address address;
    private List<Vehicle> vehicles;
    private String picture;


}

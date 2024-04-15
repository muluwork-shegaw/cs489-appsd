package cs489.project.carrental.model;
import java.util.Date;
import java.util.List;

public class Customer extends User{
    private String customerID;
    private Login login;
    private String driverLicenceId;
    private Date dob;
    private Badge badge;
    private List<Card> cards;
    private List<Reservation> reservations;


}

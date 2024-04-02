import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    private long employeeId;
    private String firstName;
    private String lastName;
    private Date employmentDate;
    private BigDecimal yearlySalary;
    private PensionPlan pensionPlan; // This will be null if the employee is not enrolled

    // Constructors, getters, setters, and any other necessary methods
}


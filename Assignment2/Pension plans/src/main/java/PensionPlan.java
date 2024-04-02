import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PensionPlan {
    private String planReferenceNumber;
    private Date enrollmentDate;
    private BigDecimal monthlyContribution;
}



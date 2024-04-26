package miu.edu.cs489.residentialpropertymgmt.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Lease1 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long leaseId;
    @NotNull
    @Column(nullable = false, unique = true)
    private Integer leaseReferenceNumber;
    @NotNull
    @DateTimeFormat(pattern ="yyy-mm-dd" )
    private LocalDate startDate;
    @NotNull
    @DateTimeFormat(pattern = "yyy-mm-dd")
    private LocalDate endDate;

}

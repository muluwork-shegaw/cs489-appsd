package cs489.project.carrental.model.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity

public class RentalAgent  extends User {

    @ManyToOne
    private Branch branch;




}

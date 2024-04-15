package cs489.project.carrental.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Map;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EqualsAndHashCode(callSuper = true)

public class RentalAgent  extends User{

    @ManyToOne
    private Branch branch;

    @OneToOne(cascade = CascadeType.ALL)
    private Login login;



}

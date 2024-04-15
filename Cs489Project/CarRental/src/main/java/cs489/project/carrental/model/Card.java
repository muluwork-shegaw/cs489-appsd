package cs489.project.carrental.model;

import cs489.project.carrental.model.helperClass.CardType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String cardID;

    @Enumerated(EnumType.STRING)
    private CardType cardType;

    private String cardNumber;
    private Integer cvv;

    @Temporal(TemporalType.DATE)
    private Date expirationDate;

    @ManyToOne
    private Customer customer;
}

package cs489.project.carrental.model;

import cs489.project.carrental.model.helperClass.CardType;

import java.util.Date;

public class Card {
    private String cardID;
    private CardType cardType;
    private String cardNumber;
    private Integer cvv;
    private Date expirationDate;
}

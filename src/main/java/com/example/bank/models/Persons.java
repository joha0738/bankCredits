package com.example.bank.models;

import javax.persistence.*;


@Entity
public class Persons {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "personId")
    @Column(name = "idperson")
    @SequenceGenerator(name = "personId",initialValue = 4)
    private Long id;

    @Column(name = "fullName",nullable = false)
    private String fullName;
    private String phoneNumber;
    private String email;
    private String cardID;

    public Persons() {
    }

    public Persons(String fullName, String phoneNumber, String email, String cardID) {
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.cardID = cardID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCardID() {
        return cardID;
    }

    public void setCardID(String cardID) {
        this.cardID = cardID;
    }
}

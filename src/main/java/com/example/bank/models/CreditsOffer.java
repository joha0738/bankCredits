package com.example.bank.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class CreditsOffer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "creditofferid")
    @Column(name = "idOffer")
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idperson")
    private Persons persons;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idcredit")
    private Credits credits;

    @OneToMany(cascade = CascadeType.ALL,fetch=FetchType.LAZY,mappedBy = "creditsOffer")
    private List<DateOfPay> dateGrids;

    private String name;
    private String credit;
    private String fullCredit;


    public List<DateOfPay> getDateGrids() {
        return dateGrids;
    }

    public void setDateGrids(List<DateOfPay> dateGrids) {
        this.dateGrids = dateGrids;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Persons getPersons() {
        return persons;
    }

    public void setPersons(Persons persons) {
        this.persons = persons;
    }

    public Credits getCredits() {
        return credits;
    }

    public void setCredits(Credits credits) {
        this.credits = credits;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCredit() {
        return credit;
    }

    public void setCredit(String credit) {
        this.credit = credit;
    }

    public String getFullCredit() {
        return fullCredit;
    }

    public void setFullCredit(String fullCredit) {
        this.fullCredit = fullCredit;
    }

}

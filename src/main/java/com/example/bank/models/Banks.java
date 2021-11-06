package com.example.bank.models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
public class Banks {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "bankId")
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idperson")
    private Persons persons;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idcredit")
    private Credits credits;

    private String name;
    private String credit;

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
}

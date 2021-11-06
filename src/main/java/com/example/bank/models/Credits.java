package com.example.bank.models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
public class Credits {

    @Id
//    @GenericGenerator(name="kaugens" , strategy="increment")
//    @GeneratedValue(generator="kaugens")
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "creditId")
    @Column(name = "idcredit")
    private Long id;

    @Column(name = "limites",nullable = false)
    private String limites;
    @Column(name = "percent")
    private String percent;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLimites() {
        return limites;
    }

    public void setLimites(String limites) {
        this.limites = limites;
    }

    public String getPercent() {
        return percent;
    }

    public void setPercent(String percent) {
        this.percent = percent;
    }
}

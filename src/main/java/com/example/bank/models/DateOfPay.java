package com.example.bank.models;

import javax.persistence.*;

@Entity
public class DateOfPay {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "dateid")
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idOffer")
    private CreditsOffer creditsOffer;

    private String date;
    private String pay;
    private String body;
    private String percent;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CreditsOffer getCreditsOffer() {
        return creditsOffer;
    }

    public void setCreditsOffer(CreditsOffer creditsOffer) {
        this.creditsOffer = creditsOffer;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPay() {
        return pay;
    }

    public void setPay(String pay) {
        this.pay = pay;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getPercent() {
        return percent;
    }

    public void setPercent(String percent) {
        this.percent = percent;
    }
}

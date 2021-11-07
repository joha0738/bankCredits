package com.example.bank.service;


import com.example.bank.models.*;
import com.example.bank.repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class CreateSrvice {

    @Autowired
    private PersonsRepository personsRepository;

    @Autowired
    private CreditsRepository creditsRepository;

    @Autowired
    private BanksRepository banksRepository;

    @Autowired
    private CreditsOfferRepository creditsOfferRepository;

    @Autowired
    private DateOfPayRepository dateOfPayRepository;

    public void createPerson(String name,String passport,String phone,String email,String limit,String percent,int month,double limit1,double percent1){

        Persons person = new Persons();
        person.setFullName(name);
        person.setCardID(passport);
        person.setPhoneNumber(phone);
        person.setEmail(email);
        personsRepository.save(person);

        Credits credit = new Credits();
        credit.setLimites(limit);
        credit.setPercent(percent);
        creditsRepository.save(credit);

        Banks bank = new Banks();
        bank.setPersons(person);
        bank.setCredits(credit);
        banksRepository.save(bank);

        CreditsOffer creditsOffer = new CreditsOffer();
        creditsOffer.setPersons(person);
        creditsOffer.setCredits(credit);
        creditsOffer.setFullCredit(String.format("%.2f",fullCredit(limit1,percent1,month)));
        creditsOffer.setName(name);
        creditsOffer.setCredit(limit);
        creditsOfferRepository.save(creditsOffer);


        createGridPay(limit1,percent1,month,creditsOffer);
    }

    public double fullCredit(double limit,double percent,int month){
        double fullCredit = limit + (limit*percent*month/1200);
        return fullCredit;
    }

    public double payOfMonth(double limit,double percent,int month){
        double pay = fullCredit(limit,percent,month)/month;
        return pay;
    }

    public double payOfBody(double limit,int month){
        double bodyCredit = limit/month;
        return bodyCredit;
    }

    public double payOfPercent(double limit,double percent){
        double percentOfPay = limit*percent/1200;
        return percentOfPay;
    }

    public void createGridPay(double limit,double percent,int month,CreditsOffer creditsOffer){

        LocalDate startdate = LocalDate.now();

        for (int i = 0; i < month; i++) {
            DateOfPay dateOfPay = new DateOfPay();
            startdate = startdate.plusMonths(1);
            dateOfPay.setDate(String.valueOf(startdate));
            dateOfPay.setPay(String.format("%.2f",payOfMonth(limit,percent,month)));
            dateOfPay.setBody(String.format("%.2f",payOfBody(limit,month)));
            dateOfPay.setPercent(String.format("%.2f",payOfPercent(limit,percent)));
            dateOfPay.setCreditsOffer(creditsOffer);
            dateOfPayRepository.save(dateOfPay);

        }

    }



}

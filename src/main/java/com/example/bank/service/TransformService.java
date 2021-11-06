package com.example.bank.service;

import com.example.bank.models.*;
import com.example.bank.repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class TransformService {

    @Autowired
    private CreateSrvice createSrvice;

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

    public void deletePerson(long id){
        Persons person = personsRepository.findById(id).orElse(null);
        Banks bank = banksRepository.findByPersonsId(id);
        Credits credit = bank.getCredits();
        List<CreditsOffer> creditsOffer = creditsOfferRepository.findByPersonsId(id);
        for(CreditsOffer creditsOffer1 : creditsOffer){
            creditsOfferRepository.delete(creditsOffer1);
        }
        banksRepository.delete(bank);
        creditsRepository.delete(credit);
        personsRepository.delete(person);
    }

    public void changePerson(long id,String name,String phone,String email,String passport){
        Persons person = personsRepository.findById(id).orElse(null);
        person.setFullName(name);
        person.setPhoneNumber(phone);
        person.setEmail(email);
        person.setCardID(passport);
        personsRepository.save(person);
    }

}

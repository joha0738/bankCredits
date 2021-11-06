package com.example.bank.controllers;

import com.example.bank.models.Banks;
import com.example.bank.models.Credits;
import com.example.bank.models.CreditsOffer;
import com.example.bank.models.Persons;
import com.example.bank.repo.BanksRepository;
import com.example.bank.repo.CreditsOfferRepository;
import com.example.bank.repo.CreditsRepository;
import com.example.bank.repo.PersonsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HeaderControllers {

    @Autowired
    private PersonsRepository personsRepository;

    @Autowired
    private BanksRepository banksRepository;

    @Autowired
    private CreditsRepository creditsRepository;

    @Autowired
    private CreditsOfferRepository creditsOfferRepository;

    @GetMapping("/clients")
    public String clients(Model model){
        List<Persons> persons = personsRepository.findAll();
        model.addAttribute("persons",persons);
        return "clients";
    }

    @GetMapping("/bank")
    public String banks(Model model){

        List<Banks> bank = banksRepository.findAll();
        model.addAttribute("banks",bank);
        return "bank";

    }

    @GetMapping("/credits")
    public String crdits(Model model){
        List<Credits> credits = creditsRepository.findAll();
        model.addAttribute("credits",credits);
        return "credits";
    }

    @GetMapping("/creditoffer")
    public String creditoffer(Model model){
        List<CreditsOffer> creditsOffer = creditsOfferRepository.findAll();
        model.addAttribute("creditsoffer",creditsOffer);
        return "creditsoffer";
    }

}

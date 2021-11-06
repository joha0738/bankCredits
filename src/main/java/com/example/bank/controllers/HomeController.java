package com.example.bank.controllers;

import com.example.bank.models.*;

import com.example.bank.repo.*;
import com.example.bank.service.CreateSrvice;
import com.example.bank.service.TransformService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private PersonsRepository personsRepository;

    @Autowired
    private BanksRepository banksRepository;

    @Autowired
    private CreditsRepository creditsRepository;

    @Autowired
    private CreateSrvice createSrvice;

    @Autowired
    private TransformService transformService;

    @Autowired
    private DateOfPayRepository dateOfPayRepository;

    @Autowired
    private CreditsOfferRepository creditsOfferRepository;

    @GetMapping("/")
    public String home(Model model){
        return "home";
    }

    @PostMapping("/")
    public String createPerson(Model model ,@RequestParam(value = "month") int month,@RequestParam(value = "limits") String limit,@RequestParam(value = "percent") String percent ,@RequestParam(value = "name") String name,@RequestParam(value = "phone") String phone,@RequestParam(value = "passport") String passport,@RequestParam(value = "email") String email ){

        double limit1 = Double.parseDouble(limit);
        double percent1 = Double.parseDouble(percent);

        createSrvice.createPerson(name,passport,phone,email,limit,percent,month,limit1,percent1);

        return "home";
    }

    @GetMapping("/client/{id}")
    public String clientid(@PathVariable(value = "id")long id, Model model){
        Persons person = personsRepository.getById(id);
        model.addAttribute("persons",person);
        return "clients";
    }

    @GetMapping("/credit/{id}")
    public String creditid(@PathVariable(value = "id")long id,Model model){
        Credits credit = creditsRepository.getById(id);
        model.addAttribute("credits",credit);
        return "credits";
    }

    @GetMapping("/creditoffer/client/{id}")
    public String creditofferclient(@PathVariable(value = "id") long id,Model model){
        List<CreditsOffer> creditsOffer = creditsOfferRepository.findByPersonsId(id);
        model.addAttribute("creditsoffer",creditsOffer);
        return "creditsoffer";
    }

    @GetMapping("/creditoffer/credit/{id}")
    public String creditoffercredit(@PathVariable(value = "id") long id,Model model){
        List<CreditsOffer> creditsOffer = creditsOfferRepository.findByCreditsId(id);
        model.addAttribute("creditsoffer",creditsOffer);
        return "creditsoffer";
    }

    @RequestMapping(value = "/clients",method = RequestMethod.POST,params = "delete")
    public String deletePerson(@RequestParam(value = "personid") long id){
        transformService.deletePerson(id);
        return "redirect:/clients";
    }

    @RequestMapping(value = "/clients",method = RequestMethod.POST,params = "save")
    public String changePerson(@RequestParam(value = "personid") long id,@RequestParam(value = "name") String name,@RequestParam(value = "phone") String phone,@RequestParam(value = "email") String email,@RequestParam(value = "passport") String passport){
        transformService.changePerson(id,name,phone,email,passport);
        return "redirect:/clients";
    }


}

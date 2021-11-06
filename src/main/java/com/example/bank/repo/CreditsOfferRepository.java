package com.example.bank.repo;


import com.example.bank.models.CreditsOffer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CreditsOfferRepository extends JpaRepository<CreditsOffer,Long> {
    List<CreditsOffer> findByPersonsId(long idperson);
    List<CreditsOffer> findByCreditsId(long idcredit);
}

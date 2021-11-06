package com.example.bank.repo;

import com.example.bank.models.Banks;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BanksRepository extends JpaRepository<Banks,Long> {
    Banks findByPersonsId(long personId);
    Banks findByCreditsId(long personId);
}

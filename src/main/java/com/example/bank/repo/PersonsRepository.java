package com.example.bank.repo;

import com.example.bank.models.Persons;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonsRepository extends JpaRepository<Persons,Long> {
}

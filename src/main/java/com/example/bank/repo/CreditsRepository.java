package com.example.bank.repo;

import com.example.bank.models.Credits;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CreditsRepository extends JpaRepository<Credits,Long> {
}

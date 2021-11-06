package com.example.bank.repo;

import com.example.bank.models.DateOfPay;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DateOfPayRepository extends JpaRepository<DateOfPay,Long> {
    List<DateOfPay> findByCreditsOfferId(long creditsOfferid);
    List<DateOfPay> deleteByCreditsOfferId(long creditsOfferid);
}

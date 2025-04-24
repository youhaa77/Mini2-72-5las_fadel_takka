package com.example.demo.repositories;

import com.example.demo.models.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

    List<Payment> findByTripId(Long tripId);

    @Query("SELECT p FROM Payment p WHERE p.amount > :amount")
    List<Payment> findPaymentsWithAmountAboveThreshold(Double amount);
}

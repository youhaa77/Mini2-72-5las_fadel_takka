package com.example.demo.repositories;

import com.example.demo.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    @Query("SELECT c FROM Customer c WHERE c.email LIKE %:domain")
    List<Customer> findByEmailDomain(String domain);

    @Query("SELECT c FROM Customer c WHERE c.phoneNumber LIKE :prefix%")
    List<Customer> findByPhonePrefix(String prefix);
}

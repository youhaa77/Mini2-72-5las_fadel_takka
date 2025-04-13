package com.example.demo.repositories;


import com.example.demo.models.Trip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TripRepository extends JpaRepository<Trip, Long> {


    @Query("SELECT t FROM Trip t WHERE t.tripDate BETWEEN :startDate AND :endDate")
    List<Trip> findTripsWithinDateRange(LocalDateTime startDate, LocalDateTime endDate);


    List<Trip> findByCaptain_Id(Long captainId);
}

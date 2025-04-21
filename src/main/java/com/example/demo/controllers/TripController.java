package com.example.demo.controllers;

import com.example.demo.models.Trip;
import com.example.demo.services.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/trip")
public class TripController {

    private final TripService tripService;

    @Autowired
    public TripController(TripService tripService) {
        this.tripService = tripService;
    }


    @GetMapping("/try")
    public String addTrip() {
        return "hahah";
    }

    // 1. Add Trip
    @PostMapping("/addTrip")
    public Trip addTrip(@RequestBody Trip trip) {
        return tripService.addTrip(trip);
    }

    // 2. Get All Trips
    @GetMapping("/allTrips")
    public List<Trip> getAllTrips() {
        return tripService.getAllTrips();
    }

    // 3. Get Trip by ID


    // 4. Update Trip
    @PutMapping("/update/{id}")
    public Trip updateTrip(@PathVariable Long id, @RequestBody Trip trip) {
        return tripService.updateTrip(id, trip);
    }

    // 5. Delete Trip
    @DeleteMapping("/delete/{id}")
    public String deleteTrip(@PathVariable Long id) {
        tripService.deleteTrip(id);
        return "Trip with ID " + id + " deleted successfully.";
    }

    // 6. Find Trips Within Date Range
    @GetMapping("/findByDateRange")
    public List<Trip> findTripsWithinDateRange(
                @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime startDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime endDate) {
        return tripService.findTripsWithinDateRange(startDate, endDate);
    }

    // 7. Find Trips by Captain ID
    @GetMapping("/findByCaptainId")
    public List<Trip> findTripsByCaptainId(@RequestParam Long captainId) {
        return tripService.findTripsByCaptainId(captainId);
    }

    @GetMapping("/{id}")
    public Trip getTripById(@PathVariable Long id) {
        return tripService.getTripById(id);
    }
}

package com.example.demo.controllers;
import com.example.demo.models.Captain;
import com.example.demo.services.CaptainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/captain")
public class CaptainController {

    private final CaptainService captainService;

    @Autowired
    public CaptainController(CaptainService captainService) {
        this.captainService = captainService;
    }

    @PostMapping("/addCaptain")
    public Captain addCaptain(@RequestBody Captain captain) {
        return captainService.addCaptain(captain);
    }

    @GetMapping("/allCaptains")
    public List<Captain> getAllCaptains() {
        return captainService.getAllCaptains();
    }

    @GetMapping("/{id}")
    public Captain getCaptainById(@PathVariable Long id) {
        return captainService.getCaptainById(id);
    }

    @GetMapping("/filterByRating")
    public List<Captain> getCaptainsByRating(@RequestParam Double ratingThreshold) {
        return captainService.getCaptainsByRating(ratingThreshold);
    }

    @GetMapping("/filterByLicenseNumber")
    public Captain getCaptainByLicenseNumber(@RequestParam String licenseNumber) {
        return captainService.getCaptainByLicenseNumber(licenseNumber);
    }
}
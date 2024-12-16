package com.book.Library.controller;

import com.book.Library.model.Rental;
import com.book.Library.service.RentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rentals")
public class RentalController {

    @Autowired
    private RentalService rentalService;

    @GetMapping
    public List<Rental> getAllRentals() {
        return rentalService.getAllRentals();
    }

    @GetMapping("/{id}")
    public Rental getRentalById(@PathVariable Long id) {
        return rentalService.getRentalById(id).orElseThrow(() -> new RuntimeException("Rental not found with id " + id));
    }

    @PostMapping
    public Rental createRental(@RequestBody Rental rental) {
        return rentalService.saveRental(rental);
    }

    @PutMapping("/{id}")
    public Rental updateRental(@PathVariable Long id, @RequestBody Rental rental) {
        return rentalService.updateRental(id, rental);
    }

    @PutMapping("/return/{id}") public Rental returnBook(@PathVariable Long id) { return rentalService.returnBook(id); }

    @DeleteMapping("/{id}")
    public void deleteRental(@PathVariable Long id) {
        rentalService.deleteRental(id);
    }
}

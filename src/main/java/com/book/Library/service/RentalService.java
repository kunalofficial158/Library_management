package com.book.Library.service;

import com.book.Library.model.Rental;
import com.book.Library.repository.RentalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class RentalService {

    @Autowired
    private RentalRepository rentalRepository;

    public List<Rental> getAllRentals() {
        return rentalRepository.findAll();
    }

    public Optional<Rental> getRentalById(Long id) {
        return rentalRepository.findById(id);
    }

    public Rental saveRental(Rental rental) {
        if (rental.getBook() == null || rental.getBook().getId() == null) {
            throw new IllegalArgumentException("Rental must have a valid Book object.");
        }
        if (isBookRented(rental.getBook().getId())) {
            throw new RuntimeException("The book is already rented out and cannot be rented again.");
        }
        return rentalRepository.save(rental);
    }

    public Rental updateRental(Long id, Rental rental) {
        Optional<Rental> existingRental = rentalRepository.findById(id);
        if (existingRental.isPresent()) {
            Rental updatedRental = existingRental.get();
            if (rental.getBook() == null || rental.getBook().getId() == null) {
                throw new IllegalArgumentException("Rental must have a valid Book object.");
            }
            updatedRental.setUser(rental.getUser());
            updatedRental.setBook(rental.getBook());
            updatedRental.setRentalDate(rental.getRentalDate());
            updatedRental.setReturnDate(rental.getReturnDate());
            updatedRental.setRentalFee(rental.getRentalFee());
            return rentalRepository.save(updatedRental);
        } else {
            throw new RuntimeException("Rental not found with id " + id);
        }
    }

    public void deleteRental(Long id) {
        rentalRepository.deleteById(id);
    }

    public Rental returnBook(Long id) {
        Optional<Rental> rental = rentalRepository.findById(id);
        if (rental.isPresent()) {
            Rental returnedRental = rental.get();
            returnedRental.setReturnDate(new Date()); // Set the current date as the return date
            return rentalRepository.save(returnedRental);
        } else {
            throw new RuntimeException("Rental not found with id " + id);
        }
    }

    private boolean isBookRented(Long bookId) {
        List<Rental> rentals = rentalRepository.findAll();
        for (Rental rental : rentals) {
            if (rental.getBook().getId().equals(bookId) && rental.getReturnDate() == null) {
                return true; // The book is currently rented out
            }
        }
        return false; // The book is available for rent
    }
}
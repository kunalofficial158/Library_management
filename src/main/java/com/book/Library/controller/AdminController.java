package com.book.Library.controller;

import com.book.Library.model.Book;
import com.book.Library.model.Rental;
import com.book.Library.model.User;
import com.book.Library.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    // Book management endpoints
    @GetMapping("/books")
    public List<Book> getAllBooks() {
        return adminService.getAllBooks();
    }

    @GetMapping("/books/{id}")
    public Book getBookById(@PathVariable Long id) {
        return adminService.getBookById(id).orElseThrow(() -> new RuntimeException("Book not found with id " + id));
    }

    @PostMapping("/books")
    public Book createBook(@RequestBody Book book) {
        return adminService.saveBook(book);
    }

    @PutMapping("/books/{id}")
    public Book updateBook(@PathVariable Long id, @RequestBody Book book) {
        return adminService.updateBook(id, book);
    }

    @DeleteMapping("/books/{id}")
    public void deleteBook(@PathVariable Long id) {
        adminService.deleteBook(id);
    }

    // User management endpoints
    @GetMapping("/users")
    public List<User> getAllUsers() {
        return adminService.getAllUsers();
    }

    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable Long id) {
        return adminService.getUserById(id).orElseThrow(() -> new RuntimeException("User not found with id " + id));
    }

    @PostMapping("/users")
    public User createUser(@RequestBody User user) {
        return adminService.saveUser(user);
    }

    @PutMapping("/users/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User user) {
        return adminService.updateUser(id, user);
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable Long id) {
        adminService.deleteUser(id);
    }

    // Rental management endpoints
    @GetMapping("/rentals")
    public List<Rental> getAllRentals() {
        return adminService.getAllRentals();
    }

    @GetMapping("/rentals/{id}")
    public Rental getRentalById(@PathVariable Long id) {
        return adminService.getRentalById(id).orElseThrow(() -> new RuntimeException("Rental not found with id " + id));
    }

    @PostMapping("/rentals")
    public Rental createRental(@RequestBody Rental rental) {
        return adminService.saveRental(rental);
    }

    @PutMapping("/rentals/{id}")
    public Rental updateRental(@PathVariable Long id, @RequestBody Rental rental) {
        return adminService.updateRental(id, rental);
    }

    @DeleteMapping("/rentals/{id}")
    public void deleteRental(@PathVariable Long id) {
        adminService.deleteRental(id);
    }
}

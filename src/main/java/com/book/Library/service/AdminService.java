package com.book.Library.service;

import com.book.Library.model.Book;
import com.book.Library.model.Rental;
import com.book.Library.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService {

    @Autowired
    private BookService bookService;

    @Autowired
    private UserService userService;

    @Autowired
    private RentalService rentalService;

    // Book management
    public List<Book> getAllBooks() {
        return bookService.getAllBooks(null,null,null);
    }

    public Optional<Book> getBookById(Long id) {
        return bookService.getBookById(id);
    }

    public Book saveBook(Book book) {
        return bookService.saveBook(book);
    }

    public Book updateBook(Long id, Book book) {
        return bookService.updateBook(id, book);
    }

    public void deleteBook(Long id) {
        bookService.deleteBook(id);
    }

    // User management
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    public Optional<User> getUserById(Long id) {
        return userService.getUserById(id);
    }

    public User saveUser(User user) {
        return userService.saveUser(user);
    }

    public User updateUser(Long id, User user) {
        return userService.updateUser(id, user);
    }

    public void deleteUser(Long id) {
        userService.deleteUser(id);
    }

    // Rental management
    public List<Rental> getAllRentals() {
        return rentalService.getAllRentals();
    }

    public Optional<Rental> getRentalById(Long id) {
        return rentalService.getRentalById(id);
    }

    public Rental saveRental(Rental rental) {
        return rentalService.saveRental(rental);
    }

    public Rental updateRental(Long id, Rental rental) {
        return rentalService.updateRental(id, rental);
    }

    public void deleteRental(Long id) {
        rentalService.deleteRental(id);
    }
}

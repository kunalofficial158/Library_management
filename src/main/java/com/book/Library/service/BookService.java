package com.book.Library.service;

import com.book.Library.model.Book;
import com.book.Library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    // Retrieve all books or filter them based on title, author, and genre
    public List<Book> getAllBooks(String title, String author, String genre) {
        // Use the repository to find books based on the provided filters
        return bookRepository.findBooksByFilters(title, author, genre);
    }

    public Optional<Book> getBookById(Long id) {
        return bookRepository.findById(id);
    }

    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    public Book updateBook(Long id, Book book) {
        Optional<Book> existingBook = bookRepository.findById(id);
        if (existingBook.isPresent()) {
            Book updatedBook = existingBook.get();
            updatedBook.setTitle(book.getTitle());
            updatedBook.setAuthor(book.getAuthor());
            updatedBook.setGenre(book.getGenre());
            updatedBook.setIsbn(book.getIsbn());
            updatedBook.setPublicationDate(book.getPublicationDate());
            updatedBook.setRating(book.getRating());
            return bookRepository.save(updatedBook);
        } else {
            throw new RuntimeException("Book not found with id " + id);
        }
    }

    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }
}

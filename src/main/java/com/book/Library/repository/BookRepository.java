package com.book.Library.repository;

import com.book.Library.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    @Override
    List<Book> findAll();
    @Query("SELECT b FROM Book b WHERE " +
            "(COALESCE(:title, '') = '' OR b.title LIKE %:title%) AND " +
            "(COALESCE(:author, '') = '' OR b.author LIKE %:author%) AND " +
            "(COALESCE(:genre, '') = '' OR b.genre LIKE %:genre%)")
    List<Book> findBooksByFilters(String title, String author, String genre);
}

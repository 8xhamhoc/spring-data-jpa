package com.smd.learning.controller;

import com.smd.learning.entity.Book;
import com.smd.learning.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class BookController {

    private BookRepository bookRepository;

    @Autowired
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping("/books")
    public Page<Book> getBooks(Pageable pageable) {
        return bookRepository.findAll(pageable);
    }

    @PostMapping("/books")
    public Book create(@RequestBody Book book) {
        return bookRepository.save(book);
    }

    @GetMapping("/books/{bookId}")
    public Book findByName(@PathVariable("bookId") Long bookId) {
        Optional<Book> bookOptional = bookRepository.findById(bookId);

        if (!bookOptional.isPresent()) {
            throw new ResourceNotFoundException("Book id " + bookId + " not found");
        }

        return bookOptional.get();
    }

}

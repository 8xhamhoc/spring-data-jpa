package com.smd.learning.controller;

import com.smd.learning.entity.Book;
import com.smd.learning.repository.BookRepository;
import com.smd.learning.response.BooksResp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BookController {

    private BookRepository bookRepository;

    @Autowired
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping("/books")
    public ResponseEntity<List<Book>> getBooks() {
        List<Book> books = bookRepository.findAll();
        System.out.println("Book size: " + books.size());

        books.forEach(book -> {
            System.out.println("Page size: " + book.getPages().size());
            book.getPages().forEach(page -> {
                System.out.println("Page content: " + page.getContent());
            });
        });

        return new ResponseEntity(new BooksResp(books), HttpStatus.OK);
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

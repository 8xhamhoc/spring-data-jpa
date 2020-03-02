package com.smd.learning.controller;

import com.smd.learning.entity.Book;
import com.smd.learning.entity.Page;
import com.smd.learning.repository.BookRepository;
import com.smd.learning.repository.PageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PageController {

    private PageRepository pageRepository;
    private BookRepository bookRepository;

    @Autowired
    public void setPageRepository(PageRepository pageRepository) {
        this.pageRepository = pageRepository;
    }

    @Autowired
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

//    @GetMapping("/books/{bookId}/pages")
//    public org.springframework.data.domain.Page<Page> getAllByBookId(@PathVariable("bookId") Long bookId, Pageable pageable) {
//        org.springframework.data.domain.Page<Page> pages = pageRepository.findByBookId(bookId, pageable);
//        return pages;
//    }

    @GetMapping("/books/{bookId}/pages")
    public List<Page> getAllByBookId(@PathVariable("bookId") Long bookId) {
        List<Page> pages = pageRepository.findByBookId(bookId);
        return pages;
    }


    @PostMapping("/books/{bookId}/pages")
    public Page create(@PathVariable("bookId") Long bookId, @RequestBody Page page) {
        return bookRepository.findById(bookId).map(book -> {
            page.setBook(book);
            return pageRepository.save(page);
        }).orElseThrow(() -> new ResourceNotFoundException("Book id " + bookId + " not found"));
    }

    @PutMapping("/books/{bookId}/pages/{pageId}")
    public Page update(@PathVariable("bookId") Long bookId, @PathVariable("pageId") Long pageId, @RequestBody Page pageRequest) {
        Optional<Book> bookOptional = bookRepository.findById(bookId);

        if (!bookOptional.isPresent()) {
            throw new ResourceNotFoundException("Book id " + bookId + " not found");
        }

        return pageRepository.findById(pageId).map(page -> {
            page.setChapter(pageRequest.getChapter());
            page.setContent(pageRequest.getContent());
            page.setNumber(pageRequest.getNumber());
            return pageRepository.save(page);
        }).orElseThrow(() -> new ResourceNotFoundException("Page id " + pageId + " not found"));
    }

}

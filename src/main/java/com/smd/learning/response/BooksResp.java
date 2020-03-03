package com.smd.learning.response;

import com.smd.learning.entity.Book;

import java.io.Serializable;
import java.util.List;

public class BooksResp implements Serializable {

    private static final long serialVersionUID = 5902188273328272429L;

    private List<Book> books;

    public BooksResp(List<Book> books) {
        this.books = books;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}

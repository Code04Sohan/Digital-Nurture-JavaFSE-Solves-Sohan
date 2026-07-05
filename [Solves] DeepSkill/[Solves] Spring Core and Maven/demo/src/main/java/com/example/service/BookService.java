package com.example.service;

import com.example.repository.BookRepository;

public class BookService {
    private BookRepository bookRepository;

    // This setter method allows Spring to inject the repository automatically
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void registerNewBook() {
        System.out.println("BookService: Registering a new book...");
        bookRepository.saveBook();
    }
}
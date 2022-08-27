package com.example.cache.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.cache.dto.Book;
import com.example.cache.service.BookService;

@RestController
public class BookController
{
    private BookService bookService;


    public BookController(BookService bookService)
    {
        this.bookService = bookService;
    }
    
  
    @GetMapping("/book/{id}")
    public Book getBookInfo(@PathVariable String id) throws InterruptedException
    {

        return bookService.getBookInfo(id);


    }
    
}

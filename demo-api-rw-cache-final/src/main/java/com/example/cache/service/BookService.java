package com.example.cache.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.cache.dto.Book;

@Service
public class BookService
{
    
    @Autowired
    private RestTemplate restTemplate;  //Ideally use construction injection in production-grade code NOT autowire.
    
    @Value("${google.books.api.url}")
    private String googleBooksApiURL;
    
    
    @Cacheable("books")
    public Book getBookInfo(String id) throws InterruptedException
    {
        Thread.sleep(10000);
        Book book = restTemplate.getForObject(googleBooksApiURL, Book.class, id);
        return book;
    }

}

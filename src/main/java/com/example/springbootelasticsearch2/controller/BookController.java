package com.example.springbootelasticsearch2.controller;


import com.example.springbootelasticsearch2.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class BookController {


    @Autowired
    @Qualifier("bookRepository")
    private PagingAndSortingRepository<Book, String> bookRepository;


    @GetMapping(value = "/book/{id}")
    public Book getBook(@PathVariable String id) {

        Book book = bookRepository.findOne(id);

        return book;

    }

    @PostMapping(value = "/book/{id}")

    public Book publishBook(@PathVariable String id, Book book) {


        book.setId(id);
        book.setPublishedDate(new Date(System.currentTimeMillis()));
        bookRepository.save(book);


        return book;

    }


}



































































































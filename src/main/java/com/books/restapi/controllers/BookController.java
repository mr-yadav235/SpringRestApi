package com.books.restapi.controllers;

import com.books.restapi.models.Book;
import com.books.restapi.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

    @Autowired
    BookRepository bookRepository;

    @RequestMapping(method = RequestMethod.GET, value="/books")
    public Iterable<Book> book(){
        return bookRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/books")
    public String save(@RequestBody Book book){
        bookRepository.save(book);

        return book.getId();
    }
}

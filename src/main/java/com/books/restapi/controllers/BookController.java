package com.books.restapi.controllers;

import com.books.restapi.models.Book;
import com.books.restapi.repositories.BookRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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

    @RequestMapping(value = "/books/{id}", method = RequestMethod.GET)
    public Book getBookById(@PathVariable("id") String id){
        return bookRepository.findOneById(id);
    }
}

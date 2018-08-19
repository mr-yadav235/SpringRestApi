package com.books.restapi.controllers;

import com.books.restapi.models.Book;
import com.books.restapi.repositories.BookRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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

    @RequestMapping(value = "/books/{id}", method = RequestMethod.PUT)
    public Book editById(@PathVariable("id") String id, @Valid @RequestBody Book book){
        Book books = bookRepository.findOneById(id);
        if(books.getTitle() != null)
            books.setTitle(book.getTitle());
        if(books.getDescription() != null)
            books.setDescription(book.getDescription());
        if(books.getPages() != 0)
            books.setPages(book.getPages());
        if(books.getBuy_url() != null)
            books.setBuy_url(book.getBuy_url());
        if(books.getIsbn() != null)
            books.setIsbn(book.getIsbn());
        if(books.getReviews() != null)
            books.setReviews(book.getReviews());
        if(books.getGenre() != null)
            books.setGenre(book.getGenre());
        if(books.getPublisher() != null)
            books.setPublisher(book.getPublisher());
        if(books.getAuthor() != null)
            books.setAuthor(book.getAuthor());
        if(books.getReleaseDate() != null)
            books.setReleaseDate(book.getReleaseDate());

        return books;

    }

    @RequestMapping(method=RequestMethod.DELETE, value="/books/{id}")
    public String delete(@PathVariable String id) {
        Book book = bookRepository.findOneById(id);
        bookRepository.delete(book);

        return "product deleted";
    }

}

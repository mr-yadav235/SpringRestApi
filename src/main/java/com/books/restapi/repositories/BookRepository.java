package com.books.restapi.repositories;

import com.books.restapi.models.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookRepository extends MongoRepository<Book, String> {

    @Override
    void delete(Book deleted);
}

package com.wchan.bookstore.repository;

import com.wchan.bookstore.model.Book;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface BookRepository extends CrudRepository<Book, UUID> {

    List<Book> findBookByTitle(String title);
}

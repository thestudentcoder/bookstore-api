package com.wchan.bookstore.service;

import com.wchan.bookstore.dto.BookDto;

import java.util.List;

public interface BookService {

    List<BookDto> getBooks();
}

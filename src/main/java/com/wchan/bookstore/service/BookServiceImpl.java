package com.wchan.bookstore.service;

import com.wchan.bookstore.dto.BookDto;
import com.wchan.bookstore.model.Book;
import com.wchan.bookstore.repository.BookRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class BookServiceImpl implements BookService {

    private BookRepository bookRepository;

    private final ModelMapper modelMapper;

    public BookServiceImpl(BookRepository bookRepository, ModelMapper modelMapper) {
        this.bookRepository = bookRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<BookDto> getBooks() {
        Iterable<Book> all = bookRepository.findAll();
        // call StreamSupport to make it stream enabled
        // clean code guidelines means avoiding anonymous functions
        return StreamSupport.stream(all.spliterator(), false)
                .map(convertBookModeltoBookDto())
                .collect(Collectors.toList());
    }

    private Function<Book, BookDto> convertBookModeltoBookDto() {
        return book -> modelMapper.map(book, BookDto.class);
    }
}

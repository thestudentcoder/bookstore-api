package com.wchan.bookstore.controller;

import com.wchan.bookstore.dto.BookDto;
import com.wchan.bookstore.service.BookService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BookControllerTest {

    @InjectMocks
    private BookController bookController;

    @Mock
    private BookService bookService;

    @Test
    void should_ReturnBookDtoList_When_GetBooksCalled() {
        List<BookDto> bookDtos = new ArrayList<>();
        bookDtos.add(getBookDto());

        when(bookService.getBooks()).thenReturn(bookDtos);
        ResponseEntity<List<BookDto>> response = bookController.getBooks();

        assertThat(response).isNotNull();
        assertThat(response.getBody()).size().isEqualTo(1);
    }

    private BookDto getBookDto() {
        return BookDto.builder()
                .title("test title")
                .description("test description")
                .id(UUID.randomUUID())
                .releaseYear(2020)
                .build();
    }
}
package com.wchan.bookstore.repository;

import com.wchan.bookstore.model.Book;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.stream.StreamSupport;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;

    @Test
    @Sql(scripts = {"classpath:InsertInitialBookRecordsForTest.sql"})
    void should_FetchAllBooksInDb_when_findAllInvoked() {
        Iterable<Book> all = bookRepository.findAll();
        long count = StreamSupport.stream(all.spliterator(), false).count();
        assertEquals(count, 2);
    }

    @Test
    @Sql(scripts = {"classpath:InsertInitialBookRecordsForTest.sql"})
    void should_ReturnOneBook_When_TitleIsTestTitle() {
        List<Book> result = bookRepository.findBookByTitle("test title");
        assertEquals(result.size(), 1);
    }
}

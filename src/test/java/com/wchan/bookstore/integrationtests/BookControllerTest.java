package com.wchan.bookstore.integrationtests;

import com.wchan.bookstore.BookStoreApplication;
import com.wchan.bookstore.dto.BookDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.jdbc.Sql;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = BookStoreApplication.class,
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class BookControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    @Sql(scripts = {"classpath:InsertInitialBookRecordsForTest.sql"})
    void should_ReturnBooks_when_BookAPiCalled() {
        BookDto[] results = testRestTemplate.getForObject("http://localhost:" + port + "/api/v1/books", BookDto[].class);
        assertThat(results).isNotNull();
        assertThat(results.length).isEqualTo(2);
    }
}

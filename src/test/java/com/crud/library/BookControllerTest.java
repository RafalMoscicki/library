package com.crud.library;

import com.crud.library.controller.BookController;
import com.crud.library.domain.Book;
import com.crud.library.domain.BookDto;
import com.crud.library.domain.Exemplar;
import com.crud.library.domain.ExemplarStatus;
import com.crud.library.exception.BookNotFoundException;
import com.crud.library.service.BookService;
import com.crud.library.service.ExemplarService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestPropertySource("classpath:application-test.properties")
@Transactional
@ExtendWith(SpringExtension.class)
@EntityScan(basePackages = "com.crud.library")
@SpringBootTest
public class BookControllerTest {

    @Autowired
    private BookController bookController;

    @Autowired
    private ExemplarService exemplarService;

    @Autowired
    private BookService bookService;

    @Test
    public void addBookTest() {
        //Given
        BookDto bookDto = new BookDto(0, "title", "author", 1999);

        //When
        BookDto result = bookController.addBook(bookDto);

        //Then
        assertTrue(result.getId() > 0);
        assertEquals(bookDto.getAuthor(), result.getAuthor());
        assertEquals(bookDto.getTitle(), result.getTitle());
        assertEquals(bookDto.getYear(), result.getYear());
    }

    @Test
    public void getAvailableBookCountTest() throws BookNotFoundException {
        //Given
        Book book = new Book(0, "title", "author", 1999);
        Exemplar exemplar1 = new Exemplar(0, ExemplarStatus.AVAILABLE, book);
        Exemplar exemplar2 = new Exemplar(0, ExemplarStatus.AVAILABLE, book);
        book.addExemplar(exemplar1);
        book.addExemplar(exemplar2);
        Book savedBook = bookService.addBook(book);

        //When
        long result = bookController.getAvailableBookCount(savedBook.getId());

        //Then
        assertEquals(2, result);
    }
}

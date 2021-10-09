package com.crud.library;

import com.crud.library.controller.ExemplarController;
import com.crud.library.domain.Book;
import com.crud.library.domain.ExemplarDto;
import com.crud.library.domain.ExemplarStatus;
import com.crud.library.exception.BookNotFoundException;
import com.crud.library.service.BookService;
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
public class ExemplarControllerTest {

    @Autowired
    private ExemplarController exemplarController;

    @Autowired
    private BookService bookService;

    @Test
    public void shouldAddExemplar() throws BookNotFoundException {
        //Given
        Book book = new Book(0, "title", "author", 1990);
        Book savedBook = bookService.addBook(book);
        ExemplarDto exemplarDto = new ExemplarDto(0, ExemplarStatus.AVAILABLE, savedBook.getId());

        //When
        ExemplarDto result = exemplarController.addExemplar(exemplarDto);

        //Then
        assertTrue(result.getId() > 0);
        assertEquals(1, book.getExemplars().size());
    }
}

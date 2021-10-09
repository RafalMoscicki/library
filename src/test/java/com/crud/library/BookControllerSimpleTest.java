package com.crud.library;

import com.crud.library.controller.BookController;
import com.crud.library.domain.Book;
import com.crud.library.domain.BookDto;
import com.crud.library.mapper.BookMapper;
import com.crud.library.service.BookService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BookControllerSimpleTest {

    @Mock
    private BookMapper bookMapper;

    @Mock
    private BookService bookService;

    @InjectMocks
    private BookController testee;

    @Test
    public void shouldAddBook() {
        // given
        BookDto bookDto = new BookDto(0, "title", "author", 1999);
        BookDto savedBookDto = new BookDto(1, "title", "author", 1999);
        Book newBook = new Book(0, "title", "author", 1999);
        Book savedBook = new Book(1, "title", "author", 1999);
        when(bookMapper.mapToBook(bookDto)).thenReturn(newBook);
        when(bookMapper.mapToBookDto(savedBook)).thenReturn(savedBookDto);
        when(bookService.addBook(newBook)).thenReturn(savedBook);

        // when
        BookDto result = testee.addBook(bookDto);

        // then
        assertTrue(result.getId() > 0);
        assertEquals(bookDto.getAuthor(), result.getAuthor());
        assertEquals(bookDto.getTitle(), result.getTitle());
        assertEquals(bookDto.getYear(), result.getYear());
    }
}

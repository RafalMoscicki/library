package com.crud.library.controller;

import com.crud.library.domain.*;
import com.crud.library.mapper.BookMapper;
import com.crud.library.service.BookService;
import com.crud.library.exception.BookNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "v1/book")
public class BookController {

    private final BookMapper bookMapper;
    private final BookService bookService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public BookDto addBook(@RequestBody BookDto bookDto) {
        Book book = bookMapper.mapToBook(bookDto);
        Book savedBook = bookService.addBook(book);
        return bookMapper.mapToBookDto(savedBook);
    }

    @GetMapping({"bookId"})
    public long getAvailableBookCount(@PathVariable long id) throws BookNotFoundException {
        return bookService.findBookById(id).getExemplars().stream()
                .filter(exemplar -> exemplar.getStatus().equals(ExemplarStatus.AVAILABLE))
                .count();
    }
}

package com.crud.library.controller;

import com.crud.library.domain.*;
import com.crud.library.mapper.BookMapper;
import com.crud.library.service.BookDbService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "v1/book")
public class BookController {

    private final BookMapper bookMapper;
    private final BookDbService bookDbService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public BookDto addBook(@RequestBody BookDto bookDto) {
        Book book = bookMapper.mapToBook(bookDto);
        Book savedBook = bookDbService.addBook(book);
        return bookMapper.mapToBookDto(savedBook);
    }
}

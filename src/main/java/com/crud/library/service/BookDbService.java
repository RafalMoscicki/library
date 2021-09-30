package com.crud.library.service;

import com.crud.library.domain.Book;
import com.crud.library.repository.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BookDbService {

    @Autowired
    private final BookRepository bookRepository;

    public Book addBook(final Book book) {
        return bookRepository.save(book);
    }

    public Book findBookById(final long id) throws BookNotFoundException {
        return bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException(id));
    }

}

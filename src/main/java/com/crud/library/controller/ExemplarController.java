package com.crud.library.controller;

import com.crud.library.domain.ExemplarDto;
import com.crud.library.domain.Exemplar;
import com.crud.library.domain.ExemplarStatus;
import com.crud.library.exception.ExemplarNotFoundException;
import com.crud.library.mapper.ExemplarMapper;
import com.crud.library.service.BookService;
import com.crud.library.exception.BookNotFoundException;
import com.crud.library.service.ExemplarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "v1/exemplar")
public class ExemplarController {

    private final ExemplarMapper exemplarMapper;
    private final ExemplarService exemplarService;
    private final BookService bookService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ExemplarDto addExemplar(@RequestBody ExemplarDto exemplarDto)
            throws BookNotFoundException {
        Exemplar exemplar = exemplarMapper.
                mapToExemplar(exemplarDto, bookService.findBookById(exemplarDto.getBookId()));
        Exemplar savedExemplar = exemplarService.addExemplar(exemplar);
        return exemplarMapper.mapToExemplarDto(savedExemplar);
    }

    @PutMapping({"exemplarId"})
    public void updateStatus(@PathVariable long exemplarId, @RequestParam ExemplarStatus status)
            throws ExemplarNotFoundException {
        exemplarService.statusChange(exemplarId, status);
    }
}

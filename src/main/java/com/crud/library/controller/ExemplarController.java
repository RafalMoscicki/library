package com.crud.library.controller;

import com.crud.library.domain.ExemplarDto;
import com.crud.library.domain.Exemplar;
import com.crud.library.mapper.ExemplarMapper;
import com.crud.library.service.BookDbService;
import com.crud.library.service.BookNotFoundException;
import com.crud.library.service.ExemplarDbService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "v1/exemplar")
public class ExemplarController {

    private final ExemplarMapper exemplarMapper;
    private final ExemplarDbService exemplarDbService;
    private final BookDbService bookDbService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ExemplarDto addExemplar(@RequestBody ExemplarDto exemplarDto)
            throws BookNotFoundException {
        Exemplar exemplar = exemplarMapper.mapToExemplar(
                exemplarDto,
                bookDbService.findBookById(exemplarDto.getBookId()));
        Exemplar savedExemplar = exemplarDbService.addExemplar(exemplar);
        return exemplarMapper.mapToExemplarDto(savedExemplar);
    }

    @PutMapping
    public ExemplarDto updateStatus(@RequestBody ExemplarDto exemplarDto)
            throws ExemplarNotFoundException, BookNotFoundException {
        if (exemplarDbService.findExemplarById(exemplarDto.getId()).isPresent()) {
            Exemplar exemplar = exemplarMapper.mapToExemplar(
                    exemplarDto,
                    bookDbService.findBookById(exemplarDto.getId()));
            Exemplar saveExemplar = exemplarDbService.addExemplar(exemplar);
            return exemplarMapper.mapToExemplarDto(saveExemplar);
        } else {
            throw new ExemplarNotFoundException(exemplarDto.getId());
        }
    }
}

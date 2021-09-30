package com.crud.library.mapper;

import com.crud.library.domain.Book;
import com.crud.library.domain.ExemplarDto;
import com.crud.library.domain.Exemplar;
import org.springframework.stereotype.Service;

@Service
public class ExemplarMapper {

    public ExemplarDto mapToExemplarDto(Exemplar exemplar) {
        return new ExemplarDto(
                exemplar.getId(),
                exemplar.getStatus(),
                exemplar.getBook().getId()
        );
    }

    public Exemplar mapToExemplar(ExemplarDto exemplarDto, Book book) {
        return new Exemplar(
                exemplarDto.getId(),
                exemplarDto.getStatus(),
                book
        );
    }
}

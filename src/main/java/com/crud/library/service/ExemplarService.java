package com.crud.library.service;

import com.crud.library.exception.ExemplarNotFoundException;
import com.crud.library.domain.Exemplar;
import com.crud.library.domain.ExemplarStatus;
import com.crud.library.repository.ExemplarRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class ExemplarService {

    @Autowired
    private final ExemplarRepository exemplarRepository;

    public Exemplar addExemplar(final Exemplar exemplar) {
        return exemplarRepository.save(exemplar);
    }

    public void statusChange (long exemplarId, ExemplarStatus status) throws ExemplarNotFoundException {
        Exemplar exemplar = exemplarRepository.findById(exemplarId).orElseThrow(() -> new ExemplarNotFoundException(exemplarId));
        exemplar.setStatus(status);
        exemplarRepository.save(exemplar);
    }

    public Exemplar findExemplarById(final Long id) throws ExemplarNotFoundException {
        return exemplarRepository.findById(id).orElseThrow(() -> new ExemplarNotFoundException(id));
    }
}

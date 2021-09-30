package com.crud.library.service;

import com.crud.library.domain.Exemplar;
import com.crud.library.repository.ExemplarRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class ExemplarDbService {

    @Autowired
    private final ExemplarRepository exemplarRepository;

    public Exemplar addExemplar(final Exemplar exemplar) {
        return exemplarRepository.save(exemplar);
    }

    public Optional<Exemplar> findExemplarById(final Long id) {
        return exemplarRepository.findById(id);
    }
}

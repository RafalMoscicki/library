package com.crud.library.repository;

import com.crud.library.domain.Exemplar;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ExemplarRepository extends CrudRepository<Exemplar, Long> {

    @Override
    Exemplar save(Exemplar exemplar);

    @Override
    List<Exemplar> findAll();

    @Override
    Optional<Exemplar> findById(Long id);

}

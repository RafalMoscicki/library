package com.crud.library.repository;

import com.crud.library.domain.Exemplar;
import com.crud.library.domain.Rental;
import com.crud.library.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RentalRepository extends CrudRepository<Rental, Long> {

    Rental save(Rental rental);

    Optional<Rental> findByUserAndExemplarOrderByRentDateDesc(User user, Exemplar exemplar);
}

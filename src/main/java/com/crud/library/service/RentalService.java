package com.crud.library.service;

import com.crud.library.domain.Exemplar;
import com.crud.library.domain.Rental;
import com.crud.library.domain.User;
import com.crud.library.exception.RentalNotFoundException;
import com.crud.library.repository.RentalRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@AllArgsConstructor
public class RentalService {

    @Autowired
    private final RentalRepository rentalRepository;

    @Autowired
    private final Rental rental;

    public LocalDate createRentDate() {
        rental.setRentDate(LocalDate.now());
        return LocalDate.now();
    }

    public LocalDate createReturnDate() {
        rental.setReturnDate(LocalDate.now().plusMonths(1));
        return LocalDate.now().plusMonths(1);
    }

    public Rental findById(long id) throws RentalNotFoundException {
        return rentalRepository.findById(id).orElseThrow(() -> new RentalNotFoundException(id));
    }

    public Rental saveRental(final Rental rental) {
        return rentalRepository.save(rental);
    }

    public Rental createRental(Exemplar exemplar, User user) {
        return new Rental(rental.getId(), exemplar, user, createRentDate(), createReturnDate());
    }
}

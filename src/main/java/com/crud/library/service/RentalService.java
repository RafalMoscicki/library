package com.crud.library.service;

import com.crud.library.controller.RentalReturnDto;
import com.crud.library.domain.Exemplar;
import com.crud.library.domain.ExemplarStatus;
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

    public Rental saveRental(final Rental rental) {
        return rentalRepository.save(rental);
    }

    public Rental createRental(Exemplar exemplar, User user) {
        return new Rental(exemplar, user, LocalDate.now());
    }

    public Rental returnBook(User user, Exemplar exemplar, RentalReturnDto rentalReturnDto ) throws RentalNotFoundException {
        Rental rental = rentalRepository.findByExemplar_IdOrderByRentDateDesc(exemplar.getId())
                .orElseThrow(() -> new RentalNotFoundException(user.getId(), exemplar.getId()));
        if (canReturn(rentalReturnDto, exemplar)) {
            rental.setReturnDate(LocalDate.now());
            return saveRental(rental);
        }
        return rental;
    }

    private boolean canReturn(RentalReturnDto rentalReturnDto, Exemplar exemplar) {
        return exemplar.getStatus() == ExemplarStatus.BORROWED || ((exemplar.getStatus() == ExemplarStatus.DESTROYED
                || exemplar.getStatus() == ExemplarStatus.LOST) && rentalReturnDto.isPaid());
    }
}

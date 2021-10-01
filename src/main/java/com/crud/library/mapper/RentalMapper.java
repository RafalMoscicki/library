package com.crud.library.mapper;

import com.crud.library.domain.Rental;
import com.crud.library.domain.RentalDto;
import org.springframework.stereotype.Service;

@Service
public class RentalMapper {

    public RentalDto mapRentalToRentalDto(Rental rental) {
        return new RentalDto(
                rental.getId(),
                rental.getExemplar().getId(),
                rental.getUser().getId(),
                rental.getRentDate(),
                rental.getReturnDate()
        );
    }
}

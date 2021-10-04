package com.crud.library.controller;

import com.crud.library.domain.*;
import com.crud.library.exception.ExemplarNotAvailableException;
import com.crud.library.exception.ExemplarNotFoundException;
import com.crud.library.exception.RentalNotFoundException;
import com.crud.library.exception.UserNotFoundException;
import com.crud.library.mapper.RentalMapper;
import com.crud.library.service.ExemplarService;
import com.crud.library.service.RentalService;
import com.crud.library.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "v1/rental")
public class RentalController {

    private final RentalService rentalService;
    private final RentalMapper rentalMapper;
    private final UserService userService;
    private final ExemplarService exemplarService;

    @PostMapping(value = "rentBook", consumes = MediaType.APPLICATION_JSON_VALUE)
    public RentalDto rentBook(@RequestBody RentalCreationDto rentalCreationDto)
            throws ExemplarNotFoundException, UserNotFoundException, ExemplarNotAvailableException {

        User user = userService.findUserById(rentalCreationDto.getUserId());
        Exemplar exemplar = exemplarService.findExemplarById(rentalCreationDto.getExemplarId());

        if (exemplar.getStatus() == ExemplarStatus.AVAILABLE) {
            exemplarService.statusChange(rentalCreationDto.getExemplarId(), ExemplarStatus.BORROWED);
            Rental rental = rentalService.createRental(exemplar, user);
            Rental saveRental = rentalService.saveRental(rental);
            return rentalMapper.mapRentalToRentalDto(saveRental);
        } else {
            throw new ExemplarNotAvailableException(rentalCreationDto.getExemplarId());
        }
    }

    @PostMapping(value = "returnBook", consumes = MediaType.APPLICATION_JSON_VALUE)
    public RentalDto returnBook(@RequestBody RentalReturnDto rentalReturnDto)
            throws UserNotFoundException, ExemplarNotFoundException, RentalNotFoundException {
        User user = userService.findUserById(rentalReturnDto.getUserId());
        Exemplar exemplar = exemplarService.findExemplarById(rentalReturnDto.getExemplarId());
        Rental rental = rentalService.returnBook(user, exemplar, rentalReturnDto);
        if (rental.getReturnDate() != null) {
            exemplarService.statusChange(rentalReturnDto.getExemplarId(), ExemplarStatus.AVAILABLE);
        }
        return rentalMapper.mapRentalToRentalDto(rental);
    }
}

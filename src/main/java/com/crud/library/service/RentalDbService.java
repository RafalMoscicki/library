package com.crud.library.service;

import com.crud.library.repository.RentalRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RentalDbService {

    @Autowired
    private final RentalRepository rentalRepository;
}

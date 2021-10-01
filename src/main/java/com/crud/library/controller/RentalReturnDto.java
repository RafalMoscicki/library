package com.crud.library.controller;

import com.crud.library.domain.ExemplarStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class RentalReturnDto {

    private long exemplarId;
    private long userId;
    private ExemplarStatus status;
    private boolean isPaid;
}

package com.opencbs.calculator.dto.request;

import lombok.Data;

import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;

@Data
public class SchedulePayoutRequestDto {

    @Positive
    private Double creditAmount;

    @PositiveOrZero
    private Double annualRate;

    @Positive
    private Integer numOfPayments;
}

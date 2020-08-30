package com.opencbs.calculator.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MonthlyPayoutDto {

    private int month;
    private Double payment;
    private Double repaymentOfInterest;
    private Double deptRepayment;
    private Double balance;
}

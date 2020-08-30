package com.opencbs.calculator.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PayoutScheduleDto {

    List<MonthlyPayoutDto> payouts;
}

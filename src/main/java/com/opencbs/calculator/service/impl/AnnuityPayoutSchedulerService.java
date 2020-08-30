package com.opencbs.calculator.service.impl;

import com.opencbs.calculator.dto.MonthlyPayoutDto;
import com.opencbs.calculator.dto.PayoutScheduleDto;
import com.opencbs.calculator.dto.request.SchedulePayoutRequestDto;
import com.opencbs.calculator.service.PayoutSchedulerService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.opencbs.calculator.utils.NumberUtils.getPercentageOf;
import static com.opencbs.calculator.utils.NumberUtils.round;

@Service
public class AnnuityPayoutSchedulerService implements PayoutSchedulerService {

    @Override
    public PayoutScheduleDto schedulePayout(
            SchedulePayoutRequestDto schedulePayoutRequest
    ) {
        double presentValue = getPresentValue(
                schedulePayoutRequest.getCreditAmount(),
                schedulePayoutRequest.getAnnualRate(),
                schedulePayoutRequest.getNumOfPayments()
        );

        return getSchedule(
                schedulePayoutRequest.getCreditAmount(),
                schedulePayoutRequest.getAnnualRate(),
                schedulePayoutRequest.getNumOfPayments(),
                presentValue
        );
    }

    private double getPresentValue(
            double amount,
            double annualRate,
            int numberOfPayments
    ){
        double presentValue = (getPercentageOf(amount, annualRate) / 12)
                / ( 1 - Math.pow(1 + (getPercentageOf(1, annualRate) / 12), numberOfPayments * -1));

        return round(presentValue, 2);
    }

    private PayoutScheduleDto getSchedule(
            double amount,
            double annualRate,
            int numberOfPayments,
            double presentValue
    ){
        List<MonthlyPayoutDto> payouts = new ArrayList<>();

        double balance = amount;
        double monthlyRate = getMonthlyRate(annualRate);

        for (int i = 1; i <= numberOfPayments; i++) {
            double repaymentOfInterest = getPercentageOf(balance, monthlyRate);
            double deptRepayment = round(presentValue - repaymentOfInterest, 2);
            balance = round(balance - deptRepayment, 2);

            payouts.add(
                    MonthlyPayoutDto
                        .builder()
                        .month(i)
                        .payment(presentValue)
                        .repaymentOfInterest(repaymentOfInterest)
                        .deptRepayment(deptRepayment)
                        .balance(balance)
                        .build()
            );
        }

        return PayoutScheduleDto
                .builder()
                .payouts(payouts)
                .build();
    }

    private double getMonthlyRate(double annualRate){
        return annualRate / 12;
    }
}

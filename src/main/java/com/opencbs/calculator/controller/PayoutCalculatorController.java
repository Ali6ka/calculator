package com.opencbs.calculator.controller;

import com.opencbs.calculator.dto.PayoutScheduleDto;
import com.opencbs.calculator.dto.request.SchedulePayoutRequestDto;
import com.opencbs.calculator.endpoint.PayoutSchedulerEndpoint;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1")
public class PayoutCalculatorController {

    private final PayoutSchedulerEndpoint payoutSchedulerEndpoint;

    public PayoutCalculatorController(
            PayoutSchedulerEndpoint payoutSchedulerEndpoint
    ) {
        this.payoutSchedulerEndpoint = payoutSchedulerEndpoint;
    }

    @PostMapping("/calculate")
    public PayoutScheduleDto calculate(
            @Valid @RequestBody SchedulePayoutRequestDto schedulePayoutRequestDto
    ) {
        return payoutSchedulerEndpoint.calculateAnnuityPayoutSchedule(schedulePayoutRequestDto);
    }

}

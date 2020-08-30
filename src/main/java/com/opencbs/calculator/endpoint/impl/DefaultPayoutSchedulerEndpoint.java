package com.opencbs.calculator.endpoint.impl;

import com.opencbs.calculator.dto.request.SchedulePayoutRequestDto;
import com.opencbs.calculator.dto.PayoutScheduleDto;
import com.opencbs.calculator.endpoint.PayoutSchedulerEndpoint;
import com.opencbs.calculator.service.PayoutSchedulerService;
import org.springframework.stereotype.Service;

@Service
public class DefaultPayoutSchedulerEndpoint implements PayoutSchedulerEndpoint {

    private final PayoutSchedulerService payoutSchedulerService;

    public DefaultPayoutSchedulerEndpoint(
            PayoutSchedulerService payoutSchedulerService
    ) {
        this.payoutSchedulerService = payoutSchedulerService;
    }

    @Override
    public PayoutScheduleDto calculateAnnuityPayoutSchedule(
            SchedulePayoutRequestDto schedulePayoutRequestDto
    ) {
        return  payoutSchedulerService.schedulePayout(schedulePayoutRequestDto);
    }
}

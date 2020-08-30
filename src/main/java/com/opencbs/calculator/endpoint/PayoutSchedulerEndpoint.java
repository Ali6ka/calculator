package com.opencbs.calculator.endpoint;

import com.opencbs.calculator.dto.request.SchedulePayoutRequestDto;
import com.opencbs.calculator.dto.PayoutScheduleDto;

public interface PayoutSchedulerEndpoint {

    PayoutScheduleDto calculateAnnuityPayoutSchedule(SchedulePayoutRequestDto schedulePayoutRequestDto);
}

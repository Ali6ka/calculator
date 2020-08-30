package com.opencbs.calculator.service;

import com.opencbs.calculator.dto.PayoutScheduleDto;
import com.opencbs.calculator.dto.request.SchedulePayoutRequestDto;

public interface PayoutSchedulerService {

    PayoutScheduleDto schedulePayout(SchedulePayoutRequestDto schedulePayoutRequestDto);

}

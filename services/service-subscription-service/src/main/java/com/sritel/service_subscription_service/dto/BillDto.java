package com.sritel.service_subscription_service.dto;

import com.sritel.service_subscription_service.enums.BillStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class BillDto {

    private float amount;
    private BillStatus billStatus;
    private int userId;
    private int serviceId;
}

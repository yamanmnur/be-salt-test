package com.salt.salttest.dto.requests;

import com.salt.salttest.model.ConsumerStatusEnum;
import lombok.Data;

import java.util.Date;

@Data
public class ConsumerRequest {
    private String name;

    private String city;

    private String address;

    private String province;

    private Date registrationDate;

    private ConsumerStatusEnum status;
}

package com.salt.salttest.dto.data;

import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Builder
@Data
public class ConsumerData {
    private UUID id;

    private String name;

    private String city;

    private String address;

    private String province;

    private String registrationDate;

    private String status;
}

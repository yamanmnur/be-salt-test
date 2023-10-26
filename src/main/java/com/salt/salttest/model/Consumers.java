package com.salt.salttest.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@Builder
@Entity
@Table(name = "consumers")
@NoArgsConstructor
@AllArgsConstructor
public class Consumers extends BaseModel {

    private String name;

    private String address;

    private String city;

    private String province;

    private Date registrationDate;

    private ConsumerStatusEnum status;

}

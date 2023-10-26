package com.salt.salttest.core.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class MetaData {
    private String status;
    private String message;
    private String code;
}

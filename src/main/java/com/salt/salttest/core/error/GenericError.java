package com.salt.salttest.core.error;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GenericError {
    private String status;
    private String message;
    private String code;
}

package com.salt.salttest.core.utils;

import com.salt.salttest.core.error.GenericError;

public class GenericErrorUtils {
    public static GenericError validate(String message) {
        return new GenericError("false",message,"1004");
    }
    public static GenericError DatabaseGenericError = new GenericError("false","Database Transaction Error","1005");
    public static GenericError NotFound = new GenericError("false","Not Found","1006");
}

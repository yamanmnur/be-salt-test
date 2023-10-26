package com.salt.salttest.core.response;

public class GenericResponse<T> extends BasicResponse {
    public GenericResponse(MetaData metaData) {
        super(metaData);
    }

    private T data;

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }
}

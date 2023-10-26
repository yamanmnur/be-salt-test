package com.salt.salttest.services;

import com.salt.salttest.core.exception.ErrorException;
import com.salt.salttest.dto.data.ConsumerData;
import com.salt.salttest.dto.requests.ConsumerRequest;

import java.util.List;
import java.util.UUID;

public interface IConsumerService {
    ConsumerData create(ConsumerRequest request) throws ErrorException;
    ConsumerData update(ConsumerRequest request, UUID id) throws ErrorException;
    List<ConsumerData> list() throws ErrorException;
    void delete(UUID id) throws ErrorException;
    ConsumerData show(UUID id) throws ErrorException;
}

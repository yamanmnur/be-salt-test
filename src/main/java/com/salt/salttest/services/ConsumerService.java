package com.salt.salttest.services;

import com.salt.salttest.core.exception.ErrorException;
import com.salt.salttest.core.utils.GenericErrorUtils;
import com.salt.salttest.dto.data.ConsumerData;
import com.salt.salttest.dto.requests.ConsumerRequest;
import com.salt.salttest.model.Consumers;
import com.salt.salttest.repositories.IConsumerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Slf4j
@Transactional
public class ConsumerService implements IConsumerService{
    private final IConsumerRepository consumerRepository;

    public ConsumerService(IConsumerRepository consumerRepository) {
        this.consumerRepository = consumerRepository;
    }

    private String convertDateToString(Date date) {

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        return dateFormat.format(date);
    }

    @Override
    public ConsumerData create(ConsumerRequest request) throws ErrorException {
        try {
            Consumers consumers = new Consumers();
            consumers.setName(request.getName());
            consumers.setCity(request.getCity());
            consumers.setAddress(request.getAddress());
            consumers.setProvince(request.getProvince());
            consumers.setStatus(request.getStatus());
            consumers.setRegistrationDate(request.getRegistrationDate());

            Consumers saved = consumerRepository.save(consumers);

            return ConsumerData.builder()
                    .id(saved.getId())
                    .name(saved.getName())
                    .status(saved.getStatus().getAction())
                    .city(saved.getCity())
                    .address(saved.getAddress())
                    .registrationDate(convertDateToString(saved.getRegistrationDate()))
                    .province(saved.getProvince()).build();

        } catch (Exception e) {
            e.printStackTrace();
            log.error("Error When Creating Shipment", e);
            throw new ErrorException(GenericErrorUtils.DatabaseGenericError);
        }
    }

    @Override
    public ConsumerData update(ConsumerRequest request, UUID id) throws ErrorException {
        try {
            Consumers consumers = consumerRepository.findById(id).orElseThrow(() -> new ErrorException(GenericErrorUtils.NotFound));
            consumers.setName(request.getName());
            consumers.setCity(request.getCity());
            consumers.setAddress(request.getAddress());
            consumers.setProvince(request.getProvince());
            consumers.setStatus(request.getStatus());
            consumers.setRegistrationDate(request.getRegistrationDate());

            Consumers saved = consumerRepository.save(consumers);

            return ConsumerData.builder()
                    .id(saved.getId())
                    .name(saved.getName())
                    .status(saved.getStatus().getAction())
                    .city(saved.getCity())
                    .address(saved.getAddress())
                    .registrationDate(convertDateToString(saved.getRegistrationDate()))
                    .province(saved.getProvince()).build();

        } catch (ErrorException errorException) {
            throw errorException;
        } catch (Exception e) {
            e.printStackTrace();
            log.error("Error When Creating Shipment", e);
            throw new ErrorException(GenericErrorUtils.DatabaseGenericError);
        }
    }

    @Override
    public List<ConsumerData> list() throws ErrorException {
        try {
            List<Consumers> consumers = consumerRepository.findAll();

            return consumers.stream().map(x -> ConsumerData.builder()
                    .id(x.getId())
                    .name(x.getName())
                    .status(x.getStatus().getAction())
                    .city(x.getCity())
                    .address(x.getAddress())
                    .registrationDate(convertDateToString(x.getRegistrationDate()))
                    .province(x.getProvince()).build()).collect(Collectors.toList());
        } catch (Exception e) {
            // TODO: handle exception
            log.error("ERROR DATABASE: ", e);
            throw new ErrorException(GenericErrorUtils.DatabaseGenericError);
        }
    }

    @Override
    public void delete(UUID id) throws ErrorException {
        try {
            Consumers consumers = consumerRepository.findById(id).orElseThrow(() -> new ErrorException(GenericErrorUtils.NotFound));

            consumers.isDeleted = true;

            consumerRepository.save(consumers);

        } catch (ErrorException errorException) {
            throw errorException;
        } catch (Exception e) {
            e.printStackTrace();
            log.error("Error When Creating Shipment", e);
            throw new ErrorException(GenericErrorUtils.DatabaseGenericError);
        }
    }

    @Override
    public ConsumerData show(UUID id) throws ErrorException {
        try {
            Consumers consumers = consumerRepository.findById(id).orElseThrow(() -> new ErrorException(GenericErrorUtils.NotFound));

            return ConsumerData.builder()
                    .id(consumers.getId())
                    .name(consumers.getName())
                    .status(consumers.getStatus().getAction())
                    .city(consumers.getCity())
                    .address(consumers.getAddress())
                    .registrationDate(convertDateToString(consumers.getRegistrationDate()))
                    .province(consumers.getProvince()).build();

        } catch (ErrorException errorException) {
            throw errorException;
        } catch (Exception e) {
            e.printStackTrace();
            log.error("Error When Creating Shipment", e);
            throw new ErrorException(GenericErrorUtils.DatabaseGenericError);
        }
    }
}

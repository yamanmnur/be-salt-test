package com.salt.salttest.controllers;

import com.salt.salttest.core.exception.ErrorException;
import com.salt.salttest.core.response.*;
import com.salt.salttest.dto.data.ConsumerData;
import com.salt.salttest.dto.requests.ConsumerRequest;
import com.salt.salttest.services.ConsumerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("/api/v1/consumers")
@Slf4j
public class ConsumerController {

    private final ConsumerService consumerService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<GenericResponse<ConsumerData>> create(@RequestBody ConsumerRequest request) {

        try {
            ConsumerData result = consumerService.create(request);

            GenericResponse<ConsumerData> response = new GenericResponse<>(new MetaData(
                    "true",
                    "success",
                    "201"
            ));

            response.setData(result);

            return ResponseEntity.ok(response);
        } catch (ErrorException e) {
            GenericResponse<ConsumerData> response = new GenericResponse<>(new MetaData(
                    e.getError().getStatus(),
                    e.getError().getMessage(),
                    e.getError().getCode()));

            return ResponseEntity.badRequest().body(response);
        }
    }

    @GetMapping
    public ResponseEntity<GenericListResponse<ConsumerData>> get() {
        try {

            List<ConsumerData> result = consumerService.list();

            GenericListResponse<ConsumerData> response = new GenericListResponse<>(new MetaData(
                    "true",
                    "success",
                    "201"
            ));

            response.setData(result);

            return ResponseEntity.ok(response);
        } catch (ErrorException e) {
            GenericListResponse<ConsumerData> response = new GenericListResponse<>(new MetaData(
                    e.getError().getStatus(),
                    e.getError().getMessage(),
                    e.getError().getCode()));

            return ResponseEntity.badRequest().body(response);
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<GenericResponse<ConsumerData>> show(
            @PathVariable UUID id
    ) {
        try {

            ConsumerData result = consumerService.show(id);

            GenericResponse<ConsumerData> response = new GenericResponse<>(new MetaData(
                    "true",
                    "success",
                    "201"
            ));

            response.setData(result);

            return ResponseEntity.ok(response);
        } catch (ErrorException e) {
            GenericResponse<ConsumerData> response = new GenericResponse<>(new MetaData(
                    e.getError().getStatus(),
                    e.getError().getMessage(),
                    e.getError().getCode()));

            return ResponseEntity.badRequest().body(response);
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<BasicResponse> delete(@PathVariable UUID id) {
        try {
            consumerService.delete(id);

            BasicResponse response = new GenericResponse<>(new MetaData(
                    "success",
                    "Success Delete Shipper",
                    "200"
            ));

            return ResponseEntity.ok(response);
        } catch (ErrorException e) {
            BasicResponse response = new GenericResponse<>(new MetaData(
                    e.getError().getStatus(),
                    e.getError().getMessage(),
                    e.getError().getCode()));

            return ResponseEntity.badRequest().body(response);
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<GenericResponse<ConsumerData>> update(@RequestBody ConsumerRequest request, @PathVariable UUID id) {
        try {
            ConsumerData result = consumerService.update(request, id);

            GenericResponse<ConsumerData> response = new GenericResponse<>(new MetaData(
                    "true",
                    "success",
                    "200"
            ));

            response.setData(result);

            return ResponseEntity.ok(response);
        } catch (ErrorException e) {
            GenericResponse<ConsumerData> response = new GenericResponse<>(new MetaData(
                    e.getError().getStatus(),
                    e.getError().getMessage(),
                    e.getError().getCode()));

            return ResponseEntity.badRequest().body(response);
        }
    }
}

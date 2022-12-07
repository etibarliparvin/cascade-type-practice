package com.example.javid.controller;

import com.example.javid.domain.dto.AddressDto;
import com.example.javid.domain.model.Address;
import com.example.javid.domain.request.AddressCreateRequest;
import com.example.javid.service.AddressService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/address")
public class AddressController {
    private final AddressService service;

    @PostMapping
    public ResponseEntity<AddressDto> create(@RequestBody AddressCreateRequest request) {
        return new ResponseEntity<>(service.create(request), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AddressDto> findById(@PathVariable Long id) {
        return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
    }

    @GetMapping("/entity/{id}")
    public ResponseEntity<Address> getById(@PathVariable Long id) {
        return new ResponseEntity<>(service.getById(id), HttpStatus.OK);
    }
}

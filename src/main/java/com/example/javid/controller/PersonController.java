package com.example.javid.controller;

import com.example.javid.domain.dto.PersonDto;
import com.example.javid.domain.model.Person;
import com.example.javid.domain.request.PersonAndAddressCreateRequest;
import com.example.javid.domain.request.PersonCreateRequest;
import com.example.javid.domain.request.PersonUpdateRequest;
import com.example.javid.service.PersonService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/person")
public class PersonController {
    private final PersonService service;

    @PostMapping("/alone")
    public ResponseEntity<PersonDto> createAlone(@RequestBody PersonCreateRequest request) {
        return new ResponseEntity<>(service.create(request), HttpStatus.CREATED);
    }

    @PostMapping("/together")
    public ResponseEntity<PersonDto> createTogether(@RequestBody PersonAndAddressCreateRequest request) {
        return new ResponseEntity<>(service.create(request), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonDto> findById(@PathVariable Long id) {
        return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
    }

    @GetMapping("/entity/{id}")
    public ResponseEntity<Person> getById(@PathVariable Long id) {
        return new ResponseEntity<>(service.getById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<PersonDto>> findAll() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePersonById(@PathVariable Long id) {
        service.deletePersonById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<PersonDto> updatePersonById(@PathVariable Long id, @RequestBody PersonUpdateRequest request) {
        return new ResponseEntity<>(service.update(id, request), HttpStatus.OK);
    }
}

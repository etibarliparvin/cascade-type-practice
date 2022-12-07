package com.example.javid.service;

import com.example.javid.domain.dto.PersonDto;
import com.example.javid.domain.model.Person;
import com.example.javid.domain.request.PersonAndAddressCreateRequest;
import com.example.javid.domain.request.PersonCreateRequest;
import com.example.javid.domain.request.PersonUpdateRequest;

import java.util.List;

public interface PersonService {

    PersonDto create(PersonCreateRequest personCreateRequest);

    PersonDto create(PersonAndAddressCreateRequest personAndAddressCreateRequest);

    PersonDto update(Long id, PersonUpdateRequest personUpdateRequest);

    PersonDto findById(Long id);

    Person getById(Long id);

    List<PersonDto> findAll();

    void deletePersonById(Long id);
}

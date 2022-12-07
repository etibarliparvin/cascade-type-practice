package com.example.javid.service.impl;

import com.example.javid.domain.dto.AddressDto;
import com.example.javid.domain.dto.PersonDto;
import com.example.javid.domain.model.Address;
import com.example.javid.domain.model.Person;
import com.example.javid.domain.request.PersonAndAddressCreateRequest;
import com.example.javid.domain.request.PersonCreateRequest;
import com.example.javid.domain.request.PersonUpdateRequest;
import com.example.javid.mapper.AddressMapper;
import com.example.javid.mapper.PersonMapper;
import com.example.javid.repository.PersonRepository;
import com.example.javid.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {
    private final PersonRepository repository;
    private final PersonMapper mapper;
    private final AddressMapper addressMapper;

    @Override
//    @Transactional
    public PersonDto create(PersonCreateRequest personCreateRequest) {
        Person person = mapper.toPersonEntity(personCreateRequest);
//        return mapper.toPersonDto(repository.save(person));
        return mapper.toPersonDto(person);
    }

    @Override
    public PersonDto create(PersonAndAddressCreateRequest personAndAddressCreateRequest) {
        Person person = new Person();
        person.setName(personAndAddressCreateRequest.getName());
        Address address = addressMapper.toAddressEntity(personAndAddressCreateRequest.getAddress());
        person.setAddress(address);
        address.setPerson(person);
        return mapper.toPersonDto(repository.save(person));
    }

    @Override
    @Transactional
    public PersonDto update(Long id, PersonUpdateRequest personUpdateRequest) {
        Person person = repository.findById(id).get();
        Address address = person.getAddress();
        person.setName(personUpdateRequest.getName());
        address.setStreet(personUpdateRequest.getStreet());
        return mapper.toPersonDto(person);
    }

    @Override
    public PersonDto findById(Long id) {
        return mapper.toPersonDto(repository.findById(id).get());
    }

    @Override
    public Person getById(Long id) {
        return mapper.toPersonEntity(repository.findById(id).get());
    }

    @Override
    public List<PersonDto> findAll() {
        return mapper.toPersonEntity(repository.findAll());
    }

    @Override
    public void deletePersonById(Long id) {
        repository.deleteById(id);
    }
}

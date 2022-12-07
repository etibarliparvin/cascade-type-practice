package com.example.javid.service.impl;

import com.example.javid.domain.dto.AddressDto;
import com.example.javid.domain.model.Address;
import com.example.javid.domain.request.AddressCreateRequest;
import com.example.javid.mapper.AddressMapper;
import com.example.javid.repository.AddressRepository;
import com.example.javid.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {
    private final AddressRepository repository;
    private final AddressMapper mapper;

    @Override
    public AddressDto create(AddressCreateRequest addressCreateRequest) {
        Address address = mapper.toAddressEntity(addressCreateRequest);
        return mapper.toAddressDto(repository.save(address));
    }

    @Override
    public AddressDto findById(Long id) {
        return mapper.toAddressDto(repository.findById(id).get());
    }

    @Override
    public Address getById(Long id) {
        return repository.findById(id).get();
    }
}

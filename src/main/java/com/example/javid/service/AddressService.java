package com.example.javid.service;

import com.example.javid.domain.dto.AddressDto;
import com.example.javid.domain.model.Address;
import com.example.javid.domain.request.AddressCreateRequest;

public interface AddressService {
    AddressDto create(AddressCreateRequest addressCreateRequest);

    AddressDto findById(Long id);

    Address getById(Long id);
}

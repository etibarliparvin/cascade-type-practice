package com.example.javid.mapper;

import com.example.javid.domain.dto.AddressDto;
import com.example.javid.domain.model.Address;
import com.example.javid.domain.request.AddressCreateRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class AddressMapper {

    public abstract Address toAddressEntity(AddressCreateRequest addressCreateRequest);

    public abstract AddressDto toAddressDto(Address address);
}

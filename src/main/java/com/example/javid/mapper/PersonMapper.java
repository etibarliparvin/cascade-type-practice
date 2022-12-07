package com.example.javid.mapper;

import com.example.javid.domain.dto.PersonDto;
import com.example.javid.domain.model.Person;
import com.example.javid.domain.request.PersonAndAddressCreateRequest;
import com.example.javid.domain.request.PersonCreateRequest;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring",
        uses = {AddressMapper.class})
public abstract class PersonMapper {

    public abstract Person toPersonEntity(PersonCreateRequest personCreateRequest);

    public abstract Person toPersonEntity(PersonAndAddressCreateRequest personAndAddressCreateRequest);

    public abstract Person toPersonEntity(Person person);

    public abstract List<PersonDto> toPersonEntity(List<Person> people);

    public abstract PersonDto toPersonDto(Person person);
}

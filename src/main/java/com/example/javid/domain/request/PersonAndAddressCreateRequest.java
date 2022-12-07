package com.example.javid.domain.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonAndAddressCreateRequest {
    private String name;
    private AddressCreateRequest address;
}

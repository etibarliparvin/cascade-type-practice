package com.example.javid.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Builder
@ToString
@NotNull
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "people")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ToString.Exclude
    @JsonIgnore
    @OneToOne(mappedBy = "person", cascade = {CascadeType.REMOVE, CascadeType.PERSIST})
    private Address address;
}

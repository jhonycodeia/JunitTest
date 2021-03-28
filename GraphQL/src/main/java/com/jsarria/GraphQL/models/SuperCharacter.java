package com.jsarria.GraphQL.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Data;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SuperCharacter {
    private String id;
    private String name;
    private Integer age;
    private SuperGroup group;
}
